package com.nilsonalves.flink_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.nilsonalves.flink_app.lists.List_Adapter;
import com.nilsonalves.flink_app.lists.Lista_Modelo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Flink_Lista extends AppCompatActivity {
    private RecyclerView listaItens;
    private ImageButton btn_code, btn_faq;
    private SearchView lista_filtro;
    private MaterialButton buscarItem;
    private FloatingActionButton confirmar_lista;
    private List_Adapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        findIds();
        btnFloat();
        pesquisar_item();

        listaItens.setLayoutManager( new LinearLayoutManager(getBaseContext()));
        listAdapter = new List_Adapter(getBaseContext(), lista_produto());
        listaItens.setAdapter(listAdapter);
    }

    private ArrayList<Lista_Modelo> lista_produto(){
        ArrayList<Lista_Modelo> list = new ArrayList<>();

        Lista_Modelo modelo = new Lista_Modelo();
        modelo.setItemCompra("Café");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Cereais");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Achocolatado");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Açúcar");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Pão de forma");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Suco");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Adoçante");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Torradas");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Geleia");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Atum");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Creme de leite");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Leite condensado");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Molho de tomate");
        list.add(modelo);

        return list;
    }

    private void findIds(){
        listaItens = findViewById(R.id.lista_compras);
        btn_code = findViewById(R.id.btn_code);
        btn_faq = findViewById(R.id.btn_faq);
        lista_filtro = findViewById(R.id.lista_filtro);
        confirmar_lista = findViewById(R.id.confirmar_lista);
        buscarItem = findViewById(R.id.buscarItem);
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

    private void pesquisar_item() {
        lista_filtro.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                listAdapter.getFilter().filter(newText);
                return false;
            }
        });
    }

}