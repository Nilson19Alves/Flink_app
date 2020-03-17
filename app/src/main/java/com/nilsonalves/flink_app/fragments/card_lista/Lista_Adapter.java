package com.nilsonalves.flink_app.fragments.card_lista;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.nilsonalves.flink_app.R;
import java.util.List;

public class Lista_Adapter extends RecyclerView.Adapter<Lista_Adapter.ViewHolder> {
    private Context context;
    private List<Lista_Modelo> modelo;

    public Lista_Adapter(Context con, List<Lista_Modelo> lista_modelo){
        this.context = con;
        this.modelo = lista_modelo;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_list_lista,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.descricaoProduto.setText(modelo.get(position).getDescricaoProduto());
        holder.qtdAddCarrinho.setText(modelo.get(position).getQtdAddCarrinho());
        holder.qtdAddFavorito.setText(modelo.get(position).getQtdAddFavorito());
        holder.valorproduto.setText(String.valueOf(modelo.get(position).getValorproduto()));
        holder.card_lista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"Clique "+ position,Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return modelo.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView descricaoProduto;
        CardView card_lista;
        ImageButton addCarrinho, addFavorito;
        TextView qtdAddCarrinho, qtdAddFavorito, valorproduto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            buscaId();

        }

        private void buscaId(){
            descricaoProduto = itemView.findViewById(R.id.descricaoProduto);
            card_lista = itemView.findViewById(R.id.card_lista);
            addCarrinho = itemView.findViewById(R.id.addCarrinho);
            addFavorito = itemView.findViewById(R.id.addFavorito);
            qtdAddCarrinho = itemView.findViewById(R.id.qtdAddCarrinho);
            qtdAddFavorito = itemView.findViewById(R.id.qtdAddFavorito);
            valorproduto = itemView.findViewById(R.id.valorproduto);
        }

    }
}
