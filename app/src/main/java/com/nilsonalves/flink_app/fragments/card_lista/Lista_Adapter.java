package com.nilsonalves.flink_app.fragments.card_lista;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.nilsonalves.flink_app.R;
import java.util.List;

public class Lista_Adapter extends RecyclerView.Adapter<Lista_Adapter.ViewHolder> {
    private Context context;
    private List<Lista_Modelo> modelo;

    public Lista_Adapter(Context con, List<Lista_Modelo> lista_modelo){
        this.context = con;
        this.modelo = lista_modelo;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_list_lista,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nomeMercado.setText(modelo.get(position).getNomeMercado());
    }

    @Override
    public int getItemCount() {
        return modelo.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageButton btn_faq, btn_code;
        TextView nomeMercado, totalPagar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            buscaId();

        }

        private void buscaId(){
            btn_faq = itemView.findViewById(R.id.btn_faq);
            btn_code = itemView.findViewById(R.id.btn_code);
            nomeMercado = itemView.findViewById(R.id.nomeMercado);
            totalPagar = itemView.findViewById(R.id.totalPagar);
        }

    }
}
