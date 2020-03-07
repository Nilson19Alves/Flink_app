package com.nilsonalves.flink_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class Flink_Lista extends AppCompatActivity {
    private ListView listaCompras;
    private ImageButton btn_code, btn_faq;
    private SearchView lista_filtro;
    private FloatingActionButton confirmar_lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        //Buscando Identificadores
        findIds();
        //Lista de compras
        listView();

        //FloatAction
        btnFloat();
    }

    private void findIds(){
        listaCompras = findViewById(R.id.lista_compras);
        btn_code = findViewById(R.id.btn_code);
        btn_faq = findViewById(R.id.btn_faq);
        lista_filtro = findViewById(R.id.lista_filtro);
        confirmar_lista = findViewById(R.id.confirmar_lista);
    }

    private void listView(){
        ArrayList<String> list = new ArrayList<String>();
        list.add("Mercado 01");
        list.add("Mercado 02");
        list.add("Mercado 03");
        list.add("Mercado 04");
        list.add("Mercado 05");
        list.add("Mercado 06");
        list.add("Mercado 07");
        list.add("Mercado 08");
        list.add("Mercado 09");
        list.add("Mercado 010");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        listaCompras.setAdapter(adapter);

        listaCompras.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getBaseContext(), i ,Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void btnFloat(){
        confirmar_lista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,"Concluir lista por aqui?", Snackbar.LENGTH_SHORT)
                        .setAction("Sim",null).show();
            }
        });
    }
}
