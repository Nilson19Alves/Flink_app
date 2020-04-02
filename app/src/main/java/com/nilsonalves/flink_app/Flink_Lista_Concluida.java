package com.nilsonalves.flink_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.nilsonalves.flink_app.lists.List_Adapter_Concluir;
import com.nilsonalves.flink_app.lists.Lista_Modelo;
import java.util.ArrayList;

public class Flink_Lista_Concluida extends AppCompatActivity {
    private RecyclerView lista_itens_confirmados;
    private List_Adapter_Concluir adapterConcluir;
    private FloatingActionButton concluirCompras;
    public static ArrayList<Lista_Modelo> pre_lista_modelo = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_itens_compra);

        buscarIds();
        setConcluirCompras();

        lista_itens_confirmados.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        adapterConcluir = new List_Adapter_Concluir(getBaseContext(),lista_produtos_concluir());
        lista_itens_confirmados.setAdapter(adapterConcluir);

    }

    private ArrayList<Lista_Modelo> lista_produtos_concluir() {
        ArrayList<Lista_Modelo> listaModelos = new ArrayList<Lista_Modelo>();
        listaModelos = pre_lista_modelo;
        Toast.makeText(getApplicationContext(), "Tamanho: " + pre_lista_modelo.size(), Toast.LENGTH_SHORT).show();

        for (int i = 0; i < listaModelos.size(); i++) {
            System.out.println(listaModelos.get(i).getItemCompra());
        }
        return listaModelos;
    }

    private void buscarIds(){
        lista_itens_confirmados = findViewById(R.id.lista_itens_confirmados);
        concluirCompras = findViewById(R.id.concluirCompras);
    }

    private void setConcluirCompras() {
        concluirCompras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Flink_Access.class);
                ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext(), R.anim.anima_activity_fade_in, R.anim.anima_atctivity_fade_out);
                intent.putExtra("fragment", "Lista");
                ActivityCompat.startActivity(Flink_Lista_Concluida.this, intent, optionsCompat.toBundle());
                finish();
            }
        });
    }

}