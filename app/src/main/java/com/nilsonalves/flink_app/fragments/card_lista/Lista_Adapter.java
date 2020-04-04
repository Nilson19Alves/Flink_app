package com.nilsonalves.flink_app.fragments.card_lista;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import com.nilsonalves.flink_app.R;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Lista_Adapter extends RecyclerView.Adapter<Lista_Adapter.ViewHolder> {
    private Context context;
    private ArrayList<Card_Lista_Modelo> modelo;
    private NumberFormat numberFormat = NumberFormat.getNumberInstance(new Locale("br"));

    public Lista_Adapter(Context con, ArrayList<Card_Lista_Modelo> cardLista_modelo){
        this.context = con;
        this.modelo = cardLista_modelo;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        numberFormat.setMinimumFractionDigits(2);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_list_lista,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.descricaoProduto.setText(modelo.get(position).getDescricaoProduto());
        String valor = "R$ " + numberFormat.format(modelo.get(position).getValorproduto());
        holder.valorproduto.setText(valor);
        System.out.println(valor);

        clickLista(holder, position);
    }

    @Override
    public int getItemCount() {
        return modelo.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView descricaoProduto, qtdAddCarrinho, qtdAddFavorito, valorproduto;
        CardView card_lista;
        MaterialButton addCarrinho, addFavorito;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            buscaId();
        }

        //Associando ids
        private void buscaId(){
            descricaoProduto = itemView.findViewById(R.id.descricaoProduto);
            qtdAddCarrinho = itemView.findViewById(R.id.qtdAddCarrinho);
            qtdAddFavorito = itemView.findViewById(R.id.qtdAddFavorito);
            valorproduto = itemView.findViewById(R.id.valorproduto);
            addCarrinho = itemView.findViewById(R.id.addCarrinho);
            addFavorito = itemView.findViewById(R.id.addFavorito);
            card_lista = itemView.findViewById(R.id.card_lista);
        }
    }

    //Evento ao click no card PRODUTO
    private void clickLista(ViewHolder viewHolder, final int position){
        viewHolder.card_lista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"Clique "+ position,Toast.LENGTH_SHORT).show();
            }
        });
    }
}