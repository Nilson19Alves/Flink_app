package com.nilsonalves.flink_app.fragments.model;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.nilsonalves.flink_app.Flink_qrCode;
import com.nilsonalves.flink_app.R;

public class Card_Holder extends RecyclerView.ViewHolder implements onClickCard{
    TextView distancia_card;
    TextView title_card;
    TextView classifica_card;
    TextView status_card;
    TextView endereco_card;
    ImageButton localiza_mercado;
    ImageButton btn_code;
    onClickCard onClickCard;
    Context context;

    Card_Holder(@NonNull View itemView) {
        super(itemView);

        findIds(itemView);

        //itemView.setOnClickListener((View.OnClickListener) this);

    }

    //Bucando Identificadores
    public void findIds(View itemView){
        title_card = itemView.findViewById(R.id.title_card);
        classifica_card = itemView.findViewById(R.id.classifica_card);
        distancia_card = itemView.findViewById(R.id.distancia_card);
        status_card = itemView.findViewById(R.id.status_card);
        endereco_card = itemView.findViewById(R.id.endereco_card);
        localiza_mercado = itemView.findViewById(R.id.localiza_mercado);
        btn_code = itemView.findViewById(R.id.btn_code);

    }

    //Acesso ao mapa do mercado
    public void mapMercado(){
        localiza_mercado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent map = new Intent();
                context.startActivity(map);
            }
        });
    }

    //Abrindo câmera QR Code
    public void qrCode(){
        btn_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent code = new Intent(context, Flink_qrCode.class);
                context.startActivity(code);
            }
        });
    }

    @Override
    public void onClickCard(View view, int position) {
        this.onClickCard.onClickCard(view,getLayoutPosition());
    }

    public void setItemClick(AdapterView.OnItemClickListener click){
        this.onClickCard = (com.nilsonalves.flink_app.fragments.model.onClickCard) click;
    }
}