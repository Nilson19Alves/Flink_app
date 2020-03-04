package com.nilsonalves.flink_app.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.nilsonalves.flink_app.R;

public class Fragment_Home extends Fragment {
    private ListView lista_supermer;
    private ImageButton btn_faq, btn_code;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        lista_supermer = (ListView)view.findViewById(R.id.lista_supermer);
        final String[] listalis = {"Supermercado 01","Supermercado 02","Supermercado 03","Supermercado 04",
                "Supermercado 05","Supermercado 06","Supermercado 07","Supermercado 08","Supermercado 09","Supermercado 10"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_list_item_1,listalis);
        lista_supermer.setAdapter(adapter);
        lista_supermer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getContext(),listalis[i],Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    public static Fragment_Home newInstance(){
        return new Fragment_Home();
    }
}