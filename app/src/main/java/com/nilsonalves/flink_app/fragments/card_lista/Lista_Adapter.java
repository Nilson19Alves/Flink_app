package com.nilsonalves.flink_app.fragments.card_lista;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.transition.Hold;
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

        clickLocalizar(holder);
        clickCarrinho(holder);
        clickFavoritos(holder);
        clickLista(holder, position);
    }

    @Override
    public int getItemCount() {
        return modelo.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    //Evento ao clicar no item de localizar o item
    private void clickLocalizar(final ViewHolder viewHolder){
        viewHolder.localizarProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"Nada implementado",Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    //Evento ao clicar para o carrinho
    private void clickFavoritos(final ViewHolder holder){
        holder.addFavorito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,holder.descricaoProduto.getText() +" adicionado a favoritos.",Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    //Evento ao clicar para favoritos
    private void clickCarrinho(final ViewHolder holder){
        holder.addCarrinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,holder.descricaoProduto.getText() +" adicionado ao carrinho.",Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    //Evento ao click no card PRODUTO
    private void clickLista(final ViewHolder viewHolder, final int position){
        viewHolder.card_lista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,viewHolder.descricaoProduto.getText(),Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView descricaoProduto, qtdAddCarrinho, qtdAddFavorito, valorproduto;
        CardView card_lista;
        MaterialButton addCarrinho, addFavorito;
        Button localizarProduto;

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
            localizarProduto = itemView.findViewById(R.id.localizarProduto);
        }
    }
}