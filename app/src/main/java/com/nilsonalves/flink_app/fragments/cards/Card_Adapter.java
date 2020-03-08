package com.nilsonalves.flink_app.fragments.cards;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nilsonalves.flink_app.R;
import com.nilsonalves.flink_app.fragments.Fragment_Home;

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
    public void onBindViewHolder(@NonNull final Card_Holder holder, int position) {
        holder.logo.setImageResource(lista_homes.get(position).getLogo());
        holder.title_card.setText(lista_homes.get(position).getTitulo());
        holder.classifica_card.setText(lista_homes.get(position).getClassifica());
        holder.distancia_card.setText(Double.toString(lista_homes.get(position).getDistancia()));
        holder.status_card.setText(lista_homes.get(position).getStatus());
        holder.endereco_card.setText(lista_homes.get(position).getEndereco());

    }

    @Override
    public int getItemCount() {
        return lista_homes.size();
    }

}