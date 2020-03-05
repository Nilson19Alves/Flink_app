package com.nilsonalves.flink_app.fragments.model;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.nilsonalves.flink_app.R;

public class Card_Holder extends RecyclerView.ViewHolder {
    TextView distancia_card;
    TextView title_card;
    TextView classifica_card;
    TextView status_card;
    TextView endereco_card;

    public Card_Holder(@NonNull View itemView) {
        super(itemView);

        distancia_card = itemView.findViewById(R.id.distancia_card);
        title_card = itemView.findViewById(R.id.title_card);
        classifica_card = itemView.findViewById(R.id.classifica_card);
        status_card = itemView.findViewById(R.id.status_card);
        endereco_card = itemView.findViewById(R.id.endereco_card);

    }
}
