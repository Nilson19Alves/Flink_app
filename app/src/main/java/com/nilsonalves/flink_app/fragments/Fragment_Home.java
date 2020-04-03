package com.nilsonalves.flink_app.fragments;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
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
import com.nilsonalves.flink_app.Flink_qrCode;
import com.nilsonalves.flink_app.R;
import com.nilsonalves.flink_app.Util.SessionManager;
import com.nilsonalves.flink_app.fragments.card_home.Home_Adapter;
import com.nilsonalves.flink_app.fragments.card_home.Home_Modelo;
import com.nilsonalves.flink_app.jdbc.Connect_info;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Fragment_Home extends Fragment {
    private RecyclerView lista_supermer;
    private Home_Adapter adapter;
    private TextView title_home_user;
    private ImageButton btn_code, btn_faq;
    private ProgressBar progress_mercados;
    SessionManager sessionManager;
    private final String url = "https://testeflink.000webhostapp.com/Conexao_mysql/Home.php";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        title_home_user = view.findViewById(R.id.title_home_user);
        lista_supermer = view.findViewById(R.id.recycle_lista);
        btn_code = view.findViewById(R.id.btn_code);
        btn_faq = view.findViewById(R.id.btn_faq);
        progress_mercados = view.findViewById(R.id.progress_mercados);

        lista_supermer.setLayoutManager(new LinearLayoutManager(getContext()));

        //lista_home();
        new encontrar_mercado().execute();
        ClickQRBottom();

        sessionManager = new SessionManager(getContext());
        HashMap<String, String> user = sessionManager.getUserDetail();
        String nome = "OI, " + user.get(sessionManager.NOME) + "!";
        title_home_user.setText(nome);

        return view;
    }

    //Instância do fragmento Home
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

                            ArrayList<Home_Modelo> list = new ArrayList<>();

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject json_mercado = jsonArray.getJSONObject(i);

                                Home_Modelo listaHome = new Home_Modelo();
                                listaHome.setTitulo(json_mercado.getString("Nome"));
                                listaHome.setClassifica(json_mercado.getString("Classificacao"));
                                listaHome.setDistancia(Double.parseDouble(json_mercado.getString("Distancia")));
                                listaHome.setStatus(json_mercado.getString("Status"));
                                listaHome.setEndereco(json_mercado.getString("Localizacao"));
                                listaHome.setURL_logo(json_mercado.getString("URL_logo"));

                                list.add(listaHome);
                            }
                            System.out.println(list.get(1).getTitulo());
                            adapter = new Home_Adapter(getContext(), list);
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

    //Botão QR Code fragmento Home
    private void ClickQRBottom(){
        btn_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent qr = new Intent(getContext(), Flink_qrCode.class);
                startActivity(qr);
            }
        });
    }

    // Consulta de mercados no banco de dados remoto
    class encontrar_mercado extends AsyncTask<Void, Void, Void> {

        ArrayList<Home_Modelo> list = new ArrayList<>();

        @Override
        protected Void doInBackground(Void... voids) {
            String sql = "SELECT * FROM Mercado;";
            Connection con = Connect_info.connection();
            try {
                Statement statement = con.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);

                while (resultSet.next()) {
                    Home_Modelo listaHome = new Home_Modelo();
                    listaHome.setTitulo(resultSet.getString("Nome"));
                    listaHome.setClassifica(resultSet.getString("Classificacao"));
                    listaHome.setDistancia(resultSet.getDouble("Distancia"));
                    listaHome.setStatus(resultSet.getString("Status"));
                    listaHome.setEndereco(resultSet.getString("Localizacao"));
                    listaHome.setURL_logo(resultSet.getString("URL_logo"));

                    System.out.println(listaHome.getTitulo());
                    list.add(listaHome);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            progress_mercados.setVisibility(View.GONE);
            adapter = new Home_Adapter(getContext(), list);
            lista_supermer.setAdapter(adapter);
            super.onPostExecute(aVoid);
        }
    }
}