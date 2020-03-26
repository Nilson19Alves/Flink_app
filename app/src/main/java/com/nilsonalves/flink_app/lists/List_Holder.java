package com.nilsonalves.flink_app.lists;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.nilsonalves.flink_app.R;

import java.util.List;

public class List_Holder extends RecyclerView.ViewHolder {
    TextView nome_item;
    AppCompatImageView item_delete,add_item;

    List_Holder(@NonNull View itemView) {
        super(itemView);
        this.nome_item = itemView.findViewById(R.id.nome_item);
        this.add_item = itemView.findViewById(R.id.add_item);
        this.item_delete = itemView.findViewById(R.id.item_delete);
    }
}
