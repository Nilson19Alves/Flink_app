package com.nilsonalves.flink_app.lists;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.nilsonalves.flink_app.Flink_Lista_Concluida;
import com.nilsonalves.flink_app.R;
import java.util.ArrayList;
import java.util.Collection;

public class List_Adapter extends RecyclerView.Adapter<List_Holder> implements Filterable {
    private Context context;
    private ArrayList<Lista_Modelo> listaModelos;
    private ArrayList<Lista_Modelo> listaModelosAll;
    private View view;

    public List_Adapter(Context context, ArrayList<Lista_Modelo> modelos){
        this.context = context;
        this.listaModelos = modelos;
        this.listaModelosAll = new ArrayList<>(modelos);
    }

    @NonNull
    @Override
    public List_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_compras,null);
        return new List_Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final List_Holder holder, final int position) {
        holder.nome_item.setText(listaModelos.get(position).getItemCompra());
        holder.add_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    removeItem(position);
                    String item = holder.nome_item.toString();

                    Snackbar.make(v,"Item inserido na lista",Snackbar.LENGTH_SHORT).show();
                    System.out.println("------------------------"+ item +","+ position);
                }catch (Exception e){
                    Snackbar.make(v,"Erro ao inserir item na lista"+ e.getLocalizedMessage(),Snackbar.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaModelos.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

//    //Inserir um novo item no RecycleView
//    public void insertItem(Lista_Modelo modelo){
//        listaModelos.add(modelo);
//        notifyItemInserted(getItemCount());
//    }

    public void removeItem(int position){
        listaModelos.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,listaModelos.size());
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    private Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            ArrayList<Lista_Modelo> filterRes = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filterRes.addAll(listaModelosAll);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (Lista_Modelo item : listaModelosAll){
                    if (item.getItemCompra().toLowerCase().contains(filterPattern)) {
                        filterRes.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filterRes;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            listaModelos.clear();
            listaModelos.addAll((Collection<? extends Lista_Modelo>) results.values);
            notifyDataSetChanged();
        }
    };

}