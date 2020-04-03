package com.nilsonalves.flink_app;

import android.content.Intent;
import android.os.AsyncTask;
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
import com.nilsonalves.flink_app.jdbc.Connect_info;
import com.nilsonalves.flink_app.lists.List_Adapter_Concluir;
import com.nilsonalves.flink_app.lists.Lista_Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
                new save_list().execute();
            }
        });
    }

    // Salvar lista concluida no banco de dados
    class save_list extends AsyncTask<Void, Void, Void> {

        String sql = "INSERT INTO `Lista` (`ID_User`, `ID_Mercado`, `Item`) VALUES (?, ?, ?);";

        @Override
        protected Void doInBackground(Void... voids) {
            Connection con = Connect_info.connection();
            for (int i = 0; i < pre_lista_modelo.size(); i++) {

                try {
                    PreparedStatement preparedStatement = con.prepareStatement(sql);
                    preparedStatement.setInt(1, 1);
                    preparedStatement.setInt(2, 2);
                    preparedStatement.setString(3, pre_lista_modelo.get(i).getItemCompra());

                    preparedStatement.executeUpdate();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Intent intent = new Intent(getApplicationContext(), Flink_Access.class);
            ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext(), R.anim.anima_activity_fade_in, R.anim.anima_atctivity_fade_out);
            intent.putExtra("fragment", "Lista");
            ActivityCompat.startActivity(Flink_Lista_Concluida.this, intent, optionsCompat.toBundle());
            finish();
            super.onPostExecute(aVoid);
        }
    }

}