package com.nilsonalves.flink_app.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.nilsonalves.flink_app.R;

public class Fragment_Lista extends Fragment {
    CardView scannerProduto, rotamercado;
    TextView nomeMercado, totalPagar;
    RecyclerView recycle_lista;
    FloatingActionButton btnRetornarLista;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista, container, false);

        scannerProduto = view.findViewById(R.id.scannerProduto);
        rotamercado = view.findViewById(R.id.rotaMercado);
        nomeMercado = view.findViewById(R.id.nomeMercado);
        recycle_lista = view.findViewById(R.id.recycle_lista);

        recycle_lista.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }

    public static Fragment_Lista newInstance(){
        return new Fragment_Lista();
    }

}
