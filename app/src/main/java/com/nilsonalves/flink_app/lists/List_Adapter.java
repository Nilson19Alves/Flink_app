package com.nilsonalves.flink_app.lists;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.nilsonalves.flink_app.R;
import java.util.ArrayList;
import java.util.Collection;

public class List_Adapter extends RecyclerView.Adapter<List_Holder> implements Filterable {
    private Context context;
    private ArrayList<Lista_Modelo> listaModelos;
    private View view;
    private ArrayList<Lista_Modelo> list_filter;

    public List_Adapter(Context context, ArrayList<Lista_Modelo> modelos){
        this.context = context;
        this.listaModelos = modelos;
        this.list_filter = modelos;
    }

    @NonNull
    @Override
    public List_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_compras,null);
        return new List_Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final List_Holder holder, int position) {
        holder.nome_item.setText(listaModelos.get(position).getItemCompra());

        holder.add_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.add_item.setVisibility(View.GONE);
                holder.remover.setVisibility(View.VISIBLE);
            }
        });
        holder.remover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.add_item.setVisibility(View.VISIBLE);
                holder.remover.setVisibility(View.GONE);
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

    //Inserir um novo item no RecycleView
    public void insertItem(Lista_Modelo modelo){
        listaModelos.add(modelo);
        notifyItemInserted(getItemCount());
    }

    //Inserir um novo item no RecycleView
    public void removeItem(int position){
        listaModelos.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,listaModelos.size());
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            ArrayList<Lista_Modelo> filterRes = new ArrayList<>();

            if (constraint.toString().isEmpty()) {
                filterRes.addAll(list_filter);
            } else {
                for (Lista_Modelo movie : list_filter){
                    if (movie.getItemCompra().toLowerCase().contains(constraint.toString().toLowerCase())) {
                        filterRes.add(movie);
                    }
                }
            }

            FilterResults filterResults = new FilterResults();
            filterResults.values = filterRes;

            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            listaModelos.clear();
            listaModelos.addAll((Collection<? extends Lista_Modelo>) results.values);
            notifyDataSetChanged();
        }
    };

}