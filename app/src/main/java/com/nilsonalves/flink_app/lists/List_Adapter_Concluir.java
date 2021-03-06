package com.nilsonalves.flink_app.lists;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nilsonalves.flink_app.Flink_Access;
import com.nilsonalves.flink_app.R;
import com.nilsonalves.flink_app.fragments.Fragment_Lista;

import java.util.ArrayList;
import java.util.List;

public class List_Adapter_Concluir extends RecyclerView.Adapter<List_Holder> {
    private Context context;
    private ArrayList<Lista_Modelo> lista_modelos;

    public List_Adapter_Concluir(Context context, ArrayList<Lista_Modelo> listaModelos){
        this.context = context;
        this.lista_modelos = listaModelos;
    }

    @NonNull
    @Override
    public List_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_itens_concluidos,parent,false);
        return new List_Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull List_Holder holder, final int position) {
        holder.nome_item.setText(lista_modelos.get(position).getItemCompra());
        System.out.println("Holder item = " + lista_modelos.get(position).getItemCompra());

        holder.item_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeItem(position);
            }
        });
    }

    //Inserir um novo item no RecycleView
    public void removeItem(int position){
        lista_modelos.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,lista_modelos.size());
    }

    @Override
    public int getItemCount() {
        return lista_modelos.size();
    }
}
