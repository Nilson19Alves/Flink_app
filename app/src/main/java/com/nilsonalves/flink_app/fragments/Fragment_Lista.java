package com.nilsonalves.flink_app.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.nilsonalves.flink_app.Flink_Lista;
import com.nilsonalves.flink_app.Flink_qrCode;
import com.nilsonalves.flink_app.R;
import com.nilsonalves.flink_app.fragments.card_lista.Card_Lista_Modelo;
import com.nilsonalves.flink_app.fragments.card_lista.Lista_Adapter;
import java.util.ArrayList;

public class Fragment_Lista extends Fragment {
    private ImageButton btn_faq,btn_code;
    private CardView scannerProduto, rotamercado;
    private TextView nomeMercado, totalPagar;
    private RecyclerView recycle_lista;
    private FloatingActionButton btnRetornarLista;
    private Lista_Adapter listaAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista, container, false);

        recycle_lista.setLayoutManager(new LinearLayoutManager(recycle_lista.getContext()));
        listaAdapter = new Lista_Adapter(getContext(),getDadosLista());
        recycle_lista.setAdapter(listaAdapter);

        buscarIds(view);
        clickBntFloat();
        clickFaq();
        clickCode();
        return view;
    }

    private ArrayList<Card_Lista_Modelo> getDadosLista() {
        ArrayList<Card_Lista_Modelo> arrayList = new ArrayList<Card_Lista_Modelo>();

        Card_Lista_Modelo listaModelo = new Card_Lista_Modelo();

        listaModelo.setDescricaoProduto("Sorvete de Açaí com Guaraná");
        listaModelo.setQtdAddCarrinho(12);
        listaModelo.setQtdAddFavorito(5);
        listaModelo.setValorproduto(25.80);
        arrayList.add(listaModelo);

        listaModelo.setDescricaoProduto("Sorvete de Açaí com Guaraná");
        listaModelo.setQtdAddCarrinho(12);
        listaModelo.setQtdAddFavorito(5);
        listaModelo.setValorproduto(25.80);
        arrayList.add(listaModelo);

        listaModelo.setDescricaoProduto("Sorvete de Açaí com Guaraná");
        listaModelo.setQtdAddCarrinho(12);
        listaModelo.setQtdAddFavorito(5);
        listaModelo.setValorproduto(25.80);
        arrayList.add(listaModelo);

        listaModelo.setDescricaoProduto("Sorvete de Açaí com Guaraná");
        listaModelo.setQtdAddCarrinho(12);
        listaModelo.setQtdAddFavorito(5);
        listaModelo.setValorproduto(25.80);
        arrayList.add(listaModelo);

        listaModelo.setDescricaoProduto("Sorvete de Açaí com Guaraná");
        listaModelo.setQtdAddCarrinho(12);
        listaModelo.setQtdAddFavorito(5);
        listaModelo.setValorproduto(25.80);
        arrayList.add(listaModelo);

        listaModelo.setDescricaoProduto("Sorvete de Açaí com Guaraná");
        listaModelo.setQtdAddCarrinho(12);
        listaModelo.setQtdAddFavorito(5);
        listaModelo.setValorproduto(25.80);
        arrayList.add(listaModelo);

        return arrayList;
    }

    public static Fragment_Lista newInstance(){
        return new Fragment_Lista();
    }

    private void buscarIds(View view){
        btn_faq = view.findViewById(R.id.btn_faq);
        btn_code = view.findViewById(R.id.btn_code);
        scannerProduto = view.findViewById(R.id.scannerProduto);
        rotamercado = view.findViewById(R.id.rotaMercado);
        nomeMercado = view.findViewById(R.id.nomeMercado);
        totalPagar = view.findViewById(R.id.totalPagar);
        btnRetornarLista = view.findViewById(R.id.btnRetornarLista);
        recycle_lista = view.findViewById(R.id.recycle_lista);
    }

    private void clickBntFloat(){
        btnRetornarLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent volta = new Intent(getContext(), Flink_Lista.class);
                startActivity(volta);
            }
        });
    }

    private void clickFaq(){
        btn_faq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void clickCode(){
        btn_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent code = new Intent(getContext(), Flink_qrCode.class);
                startActivity(code);
            }
        });
    }

}