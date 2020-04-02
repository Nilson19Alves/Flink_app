package com.nilsonalves.flink_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.nilsonalves.flink_app.Util.SessionManager;
import com.nilsonalves.flink_app.jdbc.Connect_Remot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class Flink_Inicio extends AppCompatActivity {

    private TextView usuario;
    private Button no_Mercado;
    private Button escolher_mercado;
    private Button minhas_listas;
    private Button sair;
    private String bd;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        coletar_ID();
        ections();
    }

    private void coletar_ID() {
        usuario = findViewById(R.id.user);
        no_Mercado = findViewById(R.id.no_Mercado);
        escolher_mercado = findViewById(R.id.escolher_mercado);
        minhas_listas = findViewById(R.id.minhas_listas);
        sair = findViewById(R.id.sair);
    }

    private void ections() {
        sessionManager = new SessionManager(getApplicationContext());
        HashMap<String, String> user = sessionManager.getUserDetail();
        String nome = "Olá, " + user.get(sessionManager.NOME) + "!";
        usuario.setText(nome);

        no_Mercado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Flink_qrCode.class);
                startActivity(intent);
                finish();
            }
        });

        escolher_mercado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Flink_Access.class);
                intent.putExtra("fragment", "Home");
                startActivity(intent);
                finish();
            }
        });

        minhas_listas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Connect_Remot.connection();
                //Snackbar.make(v, "Nada Implementado", Snackbar.LENGTH_SHORT).setAction("OK", null).show();
                new myTask().execute();

            }
        });

        sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionManager.logout();
                Intent intent = new Intent(getApplicationContext(), Flink_Login.class);
                startActivity(intent);
                finish();
            }
        });
    }

    // Teste Banco de Dados Mysql com AsyncTask
    class myTask extends AsyncTask<Void, Void, Void> {

        // Antes de Task Executar
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        // Execução
        @Override
        protected Void doInBackground(Void... voids) {

            String url = "jdbc:mysql://remotemysql.com:3306/LsNEUoch4h";
            String user = "LsNEUoch4h";
            String password = "e7R8ahT7GR";
            String sql = "SELECT * FROM user";

            try {
                Connection connection = DriverManager.getConnection(url, user, password);
                //Toast.makeText(getApplicationContext(), "Conectado", Toast.LENGTH_SHORT).show();
                System.out.println("Conectado !");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("Nome"));
                    bd = resultSet.getString("Nome");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return null;
        }

        // Apos a task Finalizar
        @Override
        protected void onPostExecute(Void aVoid) {
            sair.setText(bd);
            super.onPostExecute(aVoid);
        }
    }
}
