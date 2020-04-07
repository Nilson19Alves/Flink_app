package com.nilsonalves.flink_app.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.nilsonalves.flink_app.R;

public class Fragment_Carrinho extends Fragment {
    private RecyclerView listaCarrinho;
    private FloatingActionButton floatingAdicionar;
    private Button continuarCompras;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_carrinho, container, false);

        buscarIds(view);

        listaCarrinho.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }

    public static Fragment_Carrinho newInstance(){
        return new Fragment_Carrinho();
    }

    //Associar identificadores
    private void buscarIds(View view){
        listaCarrinho = view.findViewById(R.id.listaCarrinho);
        floatingAdicionar = view.findViewById(R.id.floatingAdicionar);
        continuarCompras = view.findViewById(R.id.continuarCompras);
    }
}
