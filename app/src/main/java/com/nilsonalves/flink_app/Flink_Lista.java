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
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.nilsonalves.flink_app.lists.List_Adapter;
import com.nilsonalves.flink_app.lists.Lista_Modelo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Flink_Lista extends AppCompatActivity {
    private RecyclerView listaItens;
    private ImageButton btn_code, btn_faq;
    private SearchView lista_filtro;
    private FloatingActionButton confirmar_lista;
    private List_Adapter listAdapter;
    private String url = "https://testeflink.000webhostapp.com/Conexao_mysql/ListaProdutos.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        findIds();
        btnFloat();

        listaItens.setLayoutManager( new LinearLayoutManager(getBaseContext()));
        lista_produto();
    }

    private void lista_produto(){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray jsonArray = jsonObject.getJSONArray("Lista");

                            ArrayList<Lista_Modelo> list = new ArrayList<>();

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject json_produto = jsonArray.getJSONObject(i);

                                Lista_Modelo modelo = new Lista_Modelo();
                                modelo.setItemCompra(json_produto.getString("Nome"));
                                list.add(modelo);
                            }

                            if (list.size() >= 1) {
                                listAdapter = new List_Adapter(getBaseContext(),list);
                                listAdapter = new List_Adapter(getBaseContext(), list);
                                listaItens.setAdapter(listAdapter);
                            } else {
                                Toast.makeText(getApplicationContext(), getIntent().getExtras().getString("Mercado") + " sem estoque!", Toast.LENGTH_LONG).show();
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        onBackPressed();
                                    }
                                }, 1000);
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        Toast.makeText(getApplicationContext(), "Problema ao busca Produtos!", Toast.LENGTH_LONG).show();
                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                String mercado = Objects.requireNonNull(getIntent().getExtras()).getString("Mercado");
                assert mercado != null;
                params.put("Mercado", mercado);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);


    }

    private void findIds(){
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

}