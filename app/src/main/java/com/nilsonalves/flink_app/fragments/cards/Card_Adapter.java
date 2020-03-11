package com.nilsonalves.flink_app.fragments.cards;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.nilsonalves.flink_app.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Card_Adapter extends RecyclerView.Adapter<Card_Holder> {
    private Context context;
    private ArrayList<Lista_Home> lista_homes;

    public Card_Adapter(Context context, ArrayList<Lista_Home> lista_homes){
        this.context = context;
        this.lista_homes = lista_homes;
    }

    @NonNull
    @Override
    public Card_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_list_home,null);
        return new Card_Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Card_Holder holder, int position) {
        holder.title_card.setText(lista_homes.get(position).getTitulo());
        holder.classifica_card.setText(lista_homes.get(position).getClassifica());
        holder.distancia_card.setText(String.valueOf(lista_homes.get(position).getDistancia()));
        holder.status_card.setText(lista_homes.get(position).getStatus());
        holder.endereco_card.setText(lista_homes.get(position).getEndereco());
        Picasso.get().load(lista_homes.get(position).getURL_logo()).into(holder.logo);
//        holder.itemView.setBackgroundColor(Color.rgb(248,248,248));

    }

    @Override
    public int getItemCount() {
        return lista_homes.size();
    }
}
