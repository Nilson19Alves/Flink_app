package com.nilsonalves.flink_app.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nilsonalves.flink_app.R;
import com.nilsonalves.flink_app.fragments.model.Card_Adapter;
import com.nilsonalves.flink_app.fragments.model.Lista_Home;

import java.util.ArrayList;

public class Fragment_Home extends Fragment {
    private RecyclerView lista_supermer;
    private Card_Adapter adapter;

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
        adapter = new Card_Adapter(getContext(), getList());
        lista_supermer.setAdapter(adapter);

        return view;
    }

    private ArrayList<Lista_Home> getList(){
        ArrayList<Lista_Home> arrayList = new ArrayList<>();

        Lista_Home listaHome = new Lista_Home();
        listaHome.setTitulo("Santo Amaro");
        listaHome.setClassifica("4.6");
        listaHome.setDistancia(2);
        listaHome.setStatus("Aberto até as 22");
        listaHome.setEndereco("Av. Cruz Cabugá, 1933.");
        arrayList.add(listaHome);

        listaHome = new Lista_Home();
        listaHome.setTitulo("Boa Vista");
        listaHome.setClassifica("4.4");
        listaHome.setDistancia(1);
        listaHome.setStatus("Aberto até as 18");
        listaHome.setEndereco("R. da Santa Cruz, 144.");
        arrayList.add(listaHome);

        listaHome = new Lista_Home();
        listaHome.setTitulo("Ribeira");
        listaHome.setClassifica("5.0");
        listaHome.setDistancia(4);
        listaHome.setStatus("Aberto até as 18");
        listaHome.setEndereco("R. Bernardo Vieira de Melo, s/n.");
        arrayList.add(listaHome);

        listaHome = new Lista_Home();
        listaHome.setTitulo("Água Fria");
        listaHome.setClassifica("4.0");
        listaHome.setDistancia(3);
        listaHome.setStatus("Aberto até as 18");
        listaHome.setEndereco("Av. Beberibe, s/n.");
        arrayList.add(listaHome);

        return arrayList;
    }

    public static Fragment_Home newInstance(){
        return new Fragment_Home();
    }
}