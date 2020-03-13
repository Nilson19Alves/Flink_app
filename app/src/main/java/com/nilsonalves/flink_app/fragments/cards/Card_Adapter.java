package com.nilsonalves.flink_app.fragments.cards;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.nilsonalves.flink_app.R;
import com.squareup.picasso.Picasso;
import java.util.List;

public class Card_Adapter extends RecyclerView.Adapter<Card_Adapter.ViewHolder> {
    private Context context;
    private List<Lista_Home> lista_homes;
    private OnClickCard clickCard;

    public Card_Adapter(Context context, List<Lista_Home> list){
        this.context = context;
        this.lista_homes = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_list_home,null);
        return new ViewHolder(view, clickCard);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //holder.itemView.setBackgroundColor(Color.rgb(248,248,248));
        Picasso.get().load(lista_homes.get(position).getURL_logo()).into(holder.logo);
        holder.title_card.setText(lista_homes.get(position).getTitulo());
        holder.classifica_card.setText(lista_homes.get(position).getClassifica());
        holder.distancia_card.setText(String.valueOf(lista_homes.get(position).getDistancia()));
        holder.endereco_card.setText(lista_homes.get(position).getEndereco());

        holder.setOnClickCardListener(new OnClickCard() {
            @Override
            public void onClickCad(View view, int position) {

                Toast.makeText(view.getContext(),"Posição "+ position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return lista_homes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView title_card, distancia_card, classifica_card, endereco_card, status_card;
        ImageButton btn_code, localiza_mercado;
        ImageView logo;
        OnClickCard onClickCard;

        ViewHolder(@NonNull View itemView, OnClickCard clickCard) {
            super(itemView);

            title_card = itemView.findViewById(R.id.title_card);
            classifica_card = itemView.findViewById(R.id.classifica_card);
            distancia_card = itemView.findViewById(R.id.distancia_card);
            status_card = itemView.findViewById(R.id.status_card);
            endereco_card = itemView.findViewById(R.id.endereco_card);
            localiza_mercado = itemView.findViewById(R.id.localiza_mercado);
            btn_code = itemView.findViewById(R.id.btn_code);
            logo = itemView.findViewById(R.id.logo);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onClickCard.onClickCad(view,getAdapterPosition());
        }

        //Método setOnclick na onBindViewHolder
        private void setOnClickCardListener(OnClickCard clickCardListener){
            this.onClickCard = clickCardListener;
        }
    }

    //Interface do Click no CardView
    public interface OnClickCard{
        void onClickCad(View view, int position);
    }
}