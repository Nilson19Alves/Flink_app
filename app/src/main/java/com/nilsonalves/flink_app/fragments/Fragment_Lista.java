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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.nilsonalves.flink_app.Flink_Lista;
import com.nilsonalves.flink_app.Flink_Rota_Mercado;
import com.nilsonalves.flink_app.Flink_qrCode;
import com.nilsonalves.flink_app.R;
import com.nilsonalves.flink_app.fragments.card_lista.Card_Lista_Modelo;
import com.nilsonalves.flink_app.fragments.card_lista.Lista_Adapter;
import com.nilsonalves.flink_app.jdbc.Connect_info;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Fragment_Lista extends Fragment {
    private ImageButton btn_faq,btn_code;
    private CardView scannerProduto, rotaMercado;
    private FloatingActionButton btnRetornarLista;
    private TextView nomeMercado, totalPagar;
    private ProgressBar progressLista;
    private RecyclerView recycle_lista;
    private Lista_Adapter listaAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista, container, false);

        buscarIds(view);
        clickBntFloat();
        scannerProdutoClick();
        rotaMercadoClick();
        clickFaq();
        clickCode();

        recycle_lista.setLayoutManager(new LinearLayoutManager(getContext()));
        new itensBD().execute();

        return view;
    }

    //Criando ArrayList dos produtos da tela Feed (Fragment_Lista)
    private ArrayList<Card_Lista_Modelo> getDadosLista() {
        ArrayList<Card_Lista_Modelo> arrayList = new ArrayList<Card_Lista_Modelo>();

        Card_Lista_Modelo listaModelo = new Card_Lista_Modelo();

        listaModelo.setDescricaoProduto("Sorvete de Açaí com Guaraná");
        arrayList.add(listaModelo);

        listaModelo.setDescricaoProduto("Sorvete de Açaí com Guaraná");
        arrayList.add(listaModelo);

        return arrayList;
    }

    //Instância padrão do Fragment_Lista
    public static Fragment_Lista newInstance(){
        return new Fragment_Lista();
    }

    //Associando Ids
    private void buscarIds(View view){
        btn_faq = view.findViewById(R.id.btn_faq);
        btn_code = view.findViewById(R.id.btn_code);
        scannerProduto = view.findViewById(R.id.scannerProduto);
        rotaMercado = view.findViewById(R.id.rotaMercado);
        nomeMercado = view.findViewById(R.id.nomeMercado);
        totalPagar = view.findViewById(R.id.totalPagar);
        btnRetornarLista = view.findViewById(R.id.btnRetornarLista);
        recycle_lista = view.findViewById(R.id.recycle_lista);
        progressLista = view.findViewById(R.id.progressLista);
    }

    //Botão para scanner do produto
    private void scannerProdutoClick(){
        scannerProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rota = new Intent(getContext(), Flink_qrCode.class);
                startActivity(rota);
            }
        });
    }

    //Botão rota no mercado
    private void rotaMercadoClick(){
        rotaMercado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rota = new Intent(getContext(), Flink_Rota_Mercado.class);
                startActivity(rota);
            }
        });
    }

    //Botão para voltar para tela de Lista
    private void clickBntFloat(){
        btnRetornarLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent volta = new Intent(getContext(), Flink_Lista.class);
                startActivity(volta);
            }
        });
    }

    //Click na Interogação para saber mais
    private void clickFaq(){
        btn_faq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    //Click no Qr Code
    private void clickCode(){
        btn_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent code = new Intent(getContext(), Flink_qrCode.class);
                startActivity(code);
            }
        });
    }

    // Carregar Itens do Banco de Dados
    class itensBD extends AsyncTask<Void, Void, Void> {

        ArrayList<Card_Lista_Modelo> list = new ArrayList<>();

        @Override
        protected Void doInBackground(Void... voids) {
            Connection con = Connect_info.connection();
            String sql = "SELECT codbar, produto, peso, foto_png FROM tbl_mercado_97 ORDER BY RAND() limit 10;";
            try {
                Statement statement = con.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);

                while (resultSet.next()) {
                    Card_Lista_Modelo card_lista_modelo = new Card_Lista_Modelo();

                    card_lista_modelo.setDescricaoProduto(resultSet.getString("produto"));
                    //card_lista_modelo.setValorproduto(resultSet.getDouble("Valor"));
                    card_lista_modelo.setValorproduto(2162.20);
                    list.add(card_lista_modelo);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            listaAdapter = new Lista_Adapter(getContext(),list);
            recycle_lista.setAdapter(listaAdapter);
            super.onPostExecute(aVoid);
        }
    }
}