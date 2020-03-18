package com.nilsonalves.flink_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SearchView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.nilsonalves.flink_app.lists.List_Adapter;
import com.nilsonalves.flink_app.lists.Lista_Modelo;
import java.util.ArrayList;

public class Flink_Lista extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private RecyclerView listaItens;
    private ImageButton btn_code, btn_faq;
    private SearchView lista_filtro;
    private FloatingActionButton confirmar_lista;
    private List_Adapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        buscaIds();
        btnFloat();
        abrirQR();

        listaItens.setLayoutManager( new LinearLayoutManager(getBaseContext()));
        listAdapter = new List_Adapter(getBaseContext(), getListItens());
        listaItens.setAdapter(listAdapter);

        lista_filtro.setOnQueryTextListener(this);
    }

    private void abrirQR() {
        btn_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent qr = new Intent(getBaseContext(), Flink_qrCode.class);
                startActivity(qr);
            }
        });
    }

    private ArrayList<Lista_Modelo> getListItens(){
        ArrayList<Lista_Modelo> list = new ArrayList<Lista_Modelo>();

        Lista_Modelo modelo = new Lista_Modelo();
        modelo.setItemCompra("Leite");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Ovos");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Papel Higiênico");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Água");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Tomates");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Cerveja");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Café");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Açucar");
        list.add(modelo);

        return list;
    }

    private void buscaIds(){
        listaItens = findViewById(R.id.lista_compras);
        btn_code = findViewById(R.id.btn_code);
        btn_faq = findViewById(R.id.btn_faq);
        lista_filtro = findViewById(R.id.lista_filtro);
        confirmar_lista = findViewById(R.id.confirmar_lista);
    }

    private void btnFloat(){
        confirmar_lista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,"Lista concluida", Snackbar.LENGTH_SHORT)
                        .setAction("Sim",null).show();
            }
        });
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        return false;
    }

}