package com.nilsonalves.flink_app.lists;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.nilsonalves.flink_app.R;

public class List_Holder extends RecyclerView.ViewHolder {
    TextView nome_item;

    List_Holder(@NonNull View itemView) {
        super(itemView);
        this.nome_item = itemView.findViewById(R.id.nome_item);
    }

}
