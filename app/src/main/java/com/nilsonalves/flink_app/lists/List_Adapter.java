package com.nilsonalves.flink_app.lists;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.nilsonalves.flink_app.R;

import java.util.ArrayList;

public class List_Adapter extends RecyclerView.Adapter<List_Holder> {
    private Context context;
    private ArrayList<Lista_Modelo> listaModelos;

    public List_Adapter(Context context, ArrayList<Lista_Modelo> modelos){
        this.context = context;
        this.listaModelos = modelos;
    }

    @NonNull
    @Override
    public List_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_compras,null);
        return new List_Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull List_Holder holder, int position) {
        holder.nome_item.setText(listaModelos.get(position).getItemCompra());
    }

    @Override
    public int getItemCount() {
        return listaModelos.size();
    }

}