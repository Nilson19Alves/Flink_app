package com.nilsonalves.flink_app.fragments.card_home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.nilsonalves.flink_app.Flink_Lista;
import com.nilsonalves.flink_app.Flink_Rota_Mercado;
import com.nilsonalves.flink_app.R;
import com.squareup.picasso.Picasso;
import java.util.List;

public class Home_Adapter extends RecyclerView.Adapter<Home_Adapter.ViewHolder> {
    private Context context;
    private List<Home_Modelo> home_modelos;

    public Home_Adapter(Context context, List<Home_Modelo> list){
        this.context = context;
        this.home_modelos = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_list_home,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        //holder.itemView.setBackgroundColor(Color.rgb(248,248,248));
        Picasso.get().load(home_modelos.get(position).getURL_logo()).into(holder.logo);
        holder.title_card.setText(home_modelos.get(position).getTitulo());
        holder.classifica_card.setText(home_modelos.get(position).getClassifica());
        holder.distancia_card.setText(String.valueOf(home_modelos.get(position).getDistancia()));
        holder.status_card.setText(home_modelos.get(position).getStatus());
        holder.endereco_card.setText(home_modelos.get(position).getEndereco());

        String mercado = home_modelos.get(position).getTitulo();
        clickCards(holder, mercado);
        clickButtomMapa(holder,position);
    }

    @Override
    public int getItemCount() {
        return home_modelos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title_card, distancia_card, classifica_card, endereco_card, status_card;
        MaterialButton localiza_mercado;
        ImageView logo;
        CardView card_card;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            buscarIds();
        }

        //Associando Ids
        private void buscarIds(){
            title_card = itemView.findViewById(R.id.title_card);
            classifica_card = itemView.findViewById(R.id.classifica_card);
            distancia_card = itemView.findViewById(R.id.distancia_card);
            status_card = itemView.findViewById(R.id.status_card);
            endereco_card = itemView.findViewById(R.id.endereco_card);
            localiza_mercado = itemView.findViewById(R.id.localiza_mercado);
            logo = itemView.findViewById(R.id.logo);
            card_card = itemView.findViewById(R.id.card_card);
        }
    }

    //Evento ao clicar no card do Supermercado
    private void clickCards(final ViewHolder viewHolder, final String mercado){
        viewHolder.card_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lista = new Intent(context, Flink_Lista.class);
                lista.putExtra("Mercado", mercado);
                context.startActivity(lista);
            }
        });
    }

    //Evento ao clicar no icon mapa
    private void clickButtomMapa(ViewHolder holder, int position) {
        holder.localiza_mercado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mapa = new Intent(context, Flink_Rota_Mercado.class);
                context.startActivity(mapa);
            }
        });
    }
}