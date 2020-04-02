package com.nilsonalves.flink_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DownloadManager;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.nilsonalves.flink_app.lists.List_Adapter;
import com.nilsonalves.flink_app.lists.List_Holder;
import com.nilsonalves.flink_app.lists.Lista_Modelo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Flink_Lista extends AppCompatActivity {
    private RecyclerView listaItens, lista_itens_confirmados;
    private ImageButton btn_code, btn_faq;
    private SearchView lista_filtro;
    private FloatingActionButton confirmar_lista;
    private MaterialButton adicionarItem;
    private List_Adapter listAdapter;
    private Lista_Modelo modelo = new Lista_Modelo();
    private ArrayList<Lista_Modelo> list = new ArrayList<>();
    private ArrayList<Lista_Modelo> getList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        findIds();
        btnFloat();
        pesquisar_item();
        adcionar_item();

        listaItens.setLayoutManager( new LinearLayoutManager(getBaseContext()));
        listAdapter = new List_Adapter(getBaseContext(), lista_produto());
        listaItens.setAdapter(listAdapter);

    }

    private ArrayList<Lista_Modelo> lista_produto(){

        modelo.setItemCompra("Achocolatado");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Açúcar");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Adoçante");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Agrião");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Água sanitária");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Álcool");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Alface");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Algodão");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Alho");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Amaciante");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Arroz");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Atum");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Azeite");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Azeitonas");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Batata");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Brócolis");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Café");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Carnes e derivados");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Cebola");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Cenoura");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Cera");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Cereais");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Condicionador");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Cotonete");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Couve");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Creme de leite");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Creme dental");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Desinfetante");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Desodorante");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Detergente");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Espinafre");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Esponja");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Farinha de mandioca");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Farinha de trigo");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Feijão");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Fermento");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Filme plástico");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Filtros para café");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Fio dental");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Fósforos");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Frango");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Geleia");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Guardanapos");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Iogurte");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Lâmina de barbear");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Leite");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Leite condensado");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Limpa vidros");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Lustra-móveis");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Maisena");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Manteiga");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Margarina");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Molho de tomate");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Óleo");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Ovos");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Palha de aço");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Palitos de dente");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Pão de forma ");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Papel higiênico");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Papel toalha");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Peixe");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Pimentão");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Pipoca");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Presunto");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Queijo ralado");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Queijos");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Requeijão");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Sabão");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Sabonete");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Saco de lixo");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Sal");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Shampoo");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Suco");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Temperos");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Tomate");
        list.add(modelo);

        modelo = new Lista_Modelo();
        modelo.setItemCompra("Vinagre");
        list.add(modelo);

        return list;
    }

    private void findIds(){
        listaItens = findViewById(R.id.lista_compras);
        btn_code = findViewById(R.id.btn_code);
        btn_faq = findViewById(R.id.btn_faq);
        lista_filtro = findViewById(R.id.lista_filtro);
        confirmar_lista = findViewById(R.id.confirmar_lista);
        lista_itens_confirmados = findViewById(R.id.lista_itens_confirmados);
        adicionarItem = findViewById(R.id.adicionarItem);
    }

    private void btnFloat(){
        confirmar_lista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Flink_Lista_Concluida.class);
                startActivity(intent);
            }
        });
    }

    private void pesquisar_item() {
        lista_filtro.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                listAdapter.getFilter().filter(newText);

                // bt Adicionar
                if (lista_filtro.getQuery().length() >= 2) {
                    adicionarItem.setEnabled(true);
                    adicionarItem.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.MediumPurple)));
                } else {
                    adicionarItem.setEnabled(false);
                    adicionarItem.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.SilverWhite)));
                }

                return false;
            }
        });
    }

    private void adcionar_item() {
        adicionarItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lista_filtro.getQuery().length() >= 2) {
                    // chamada da class Flink_lista_Concluida add a pre lista
                    Lista_Modelo get_item = new Lista_Modelo();
                    get_item.setItemCompra(lista_filtro.getQuery().toString());
                    Flink_Lista_Concluida.pre_lista_modelo.add(get_item);

                    adicionarItem.setEnabled(false);
                    adicionarItem.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.SilverWhite)));
                    lista_filtro.setQuery(null, false);
                }
                // add na lista concluida
                // limpar SearchView lista_filtro;
                // setar a lista completa
            }
        });
    }

}