package com.nilsonalves.flink_app.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.nilsonalves.flink_app.R;
import com.nilsonalves.flink_app.fragments.model.Card_Adapter;
import com.nilsonalves.flink_app.fragments.model.Lista_Home;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

public class Fragment_Home extends Fragment {
    private RecyclerView lista_supermer;
    private Card_Adapter adapter;
    private final String url = "https://testeflink.000webhostapp.com/Conexao_mysql/Home.php";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        lista_supermer = view.findViewById(R.id.lista_supermer);
        lista_supermer.setLayoutManager(new LinearLayoutManager(getContext()));
        lista_home();

        return view;
    }

    public static Fragment_Home newInstance(){
        return new Fragment_Home();
    }

    // Consulta de mercados no Banco de Dados
    private void lista_home() {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            System.out.println(jsonObject.getString("Lista"));
                            JSONArray jsonArray = jsonObject.getJSONArray("Lista");
                            System.out.println(jsonArray.getString(0));
                            System.out.println(jsonArray.length());

                            ArrayList<Lista_Home> list = new ArrayList<>();

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject json_mercado = jsonArray.getJSONObject(i);

                                Lista_Home listaHome = new Lista_Home();
                                listaHome.setTitulo(json_mercado.getString("Nome"));
                                listaHome.setClassifica(json_mercado.getString("Classificacao"));
                                listaHome.setDistancia(Double.parseDouble(json_mercado.getString("Distancia")));
                                listaHome.setStatus(json_mercado.getString("Status"));
                                listaHome.setEndereco(json_mercado.getString("Localizacao"));

                                list.add(listaHome);
                            }
                            System.out.println(list.get(1).getTitulo());
                            adapter = new Card_Adapter(getContext(), list);
                            lista_supermer.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(), "Problema ao busca mercados!", Toast.LENGTH_LONG).show();
                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return super.getParams();
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);
    }

}