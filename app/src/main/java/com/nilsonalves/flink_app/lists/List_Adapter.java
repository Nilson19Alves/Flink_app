package com.nilsonalves.flink_app.lists;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.nilsonalves.flink_app.R;
import com.nilsonalves.flink_app.jdbc.Connect;

import java.util.ArrayList;

public class List_Adapter extends RecyclerView.Adapter<List_Holder> {
    private Context context;
    private ArrayList<Lista_Modelo> listaModelos;
    private View view;

    public List_Adapter(Context context, ArrayList<Lista_Modelo> modelos){
        this.context = context;
        this.listaModelos = modelos;
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
//                Snackbar.make(view,"Item Adicionado", Snackbar.LENGTH_SHORT)
//                        .setAction("Sim",null).show();
//                holder.add_item.setEnabled(false);
//                holder.add_item.setImageResource(R.drawable.icons8_checkmark_48px);
                holder.add_item.setBackgroundResource(R.drawable.icons8_checkmark_48px);
//                holder.add_item.setBackground(R.drawable.icons8_checkmark_48px);
                holder.add_item.setOnClickListener(null);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaModelos.size();
    }

}