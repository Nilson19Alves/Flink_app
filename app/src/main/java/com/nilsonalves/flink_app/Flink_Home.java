package com.nilsonalves.flink_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Flink_Home extends AppCompatActivity {

    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        coletar_ID();
        listar_mercado();
    }

    // coletar todos os componetes da activity pelo ID
    private void coletar_ID() {
        lista = findViewById(R.id.lista);
    }

    // Listar os mercados mais proximos do usuario
    private void listar_mercado() {
        List<String> arrayList = new ArrayList<>();
        arrayList.add("PANIFICADORA FLORESTA");
        arrayList.add("SUPERMERCADO COMPARE");
        arrayList.add("CONVENIÊNCIA CENTRO");
        arrayList.add("MERCADINHO SANTA ROSA");
        arrayList.add("MERCADINHO AVENIDA");
        arrayList.add("COMPARE 2");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        lista.setAdapter(arrayAdapter);

        // Event de click no item
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String clickedItem=(String) lista.getItemAtPosition(position);
                Toast.makeText(Flink_Home.this,clickedItem,Toast.LENGTH_LONG).show();
            }
        });
    }
}
