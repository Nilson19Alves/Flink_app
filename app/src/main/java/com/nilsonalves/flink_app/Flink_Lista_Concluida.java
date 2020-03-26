package com.nilsonalves.flink_app;

import android.os.Bundle;
import android.widget.Adapter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.nilsonalves.flink_app.lists.List_Adapter_Concluir;
import com.nilsonalves.flink_app.lists.List_Holder;
import com.nilsonalves.flink_app.lists.Lista_Modelo;

import java.util.ArrayList;

public class Flink_Lista_Concluida extends AppCompatActivity {
    private MaterialButton voltar, concluirCompras;
    private RecyclerView lista_itens_confirmados;
    private List_Holder holderConcluir;
    private Lista_Modelo modeloConcluir;
    private List_Adapter_Concluir adapterConcluir;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_itens_compra);

        voltar = findViewById(R.id.voltar);
        concluirCompras = findViewById(R.id.concluirCompras);

        lista_itens_confirmados.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        adapterConcluir = new List_Adapter_Concluir(getBaseContext(),lista_produtos_concluir());
        lista_itens_confirmados.setAdapter(adapterConcluir);

    }

    private ArrayList<Lista_Modelo> lista_produtos_concluir() {
        ArrayList<Lista_Modelo> listaModelos = new ArrayList<Lista_Modelo>();

        modeloConcluir.setItemCompra("");

        return listaModelos;
    }

}
