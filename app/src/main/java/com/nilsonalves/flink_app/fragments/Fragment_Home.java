package com.nilsonalves.flink_app.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nilsonalves.flink_app.R;
import com.nilsonalves.flink_app.fragments.cards.Card_Adapter;
import com.nilsonalves.flink_app.fragments.cards.Lista_Home;

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
        listaHome.setLogo(R.drawable.mercado_torre);
        listaHome.setTitulo("Mercado da Torre");
        listaHome.setClassifica("5.0");
        listaHome.setDistancia(6);
        listaHome.setStatus("Aberto até as 22:00");
        listaHome.setEndereco("R. José Bonifácio, 747 - Torre");
        arrayList.add(listaHome);

        listaHome = new Lista_Home();
        listaHome.setLogo(R.drawable.mercado_verfrut);
        listaHome.setTitulo("VerdFrut");
        listaHome.setClassifica("5.0");
        listaHome.setDistancia(0.5);
        listaHome.setStatus("Aberto até as 21:00");
        listaHome.setEndereco("R. Cap. Rebelinho, 440 - Pina");
        arrayList.add(listaHome);

        listaHome = new Lista_Home();
        listaHome.setLogo(R.drawable.mercado_diplomata);
        listaHome.setTitulo("Diplomata");
        listaHome.setClassifica("5.0");
        listaHome.setDistancia(1.2);
        listaHome.setStatus("Abre amanhã as 08:00");
        listaHome.setEndereco("Av. Herculano Bandeira, 187");
        arrayList.add(listaHome);

        listaHome = new Lista_Home();
        listaHome.setLogo(R.drawable.mercado_mutti);
        listaHome.setTitulo("Mutti");
        listaHome.setClassifica("5.0");
        listaHome.setDistancia(14);
        listaHome.setStatus("Aberto até as 22:00");
        listaHome.setEndereco("R. Pedro Bonifácio, 647");
        arrayList.add(listaHome);

        return arrayList;
    }

    public static Fragment_Home newInstance(){
        return new Fragment_Home();
    }

}