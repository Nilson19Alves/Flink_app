package com.nilsonalves.flink_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.nilsonalves.flink_app.fragments.Fragment_Carrinho;
import com.nilsonalves.flink_app.fragments.Fragment_Favorito;
import com.nilsonalves.flink_app.fragments.Fragment_Home;
import com.nilsonalves.flink_app.fragments.Fragment_Lista;
import com.nilsonalves.flink_app.fragments.Fragment_Perfil;

public class Flink_Access extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    private FrameLayout frame;
    private BottomNavigationView navegation;
    private ListView listaSuper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_access);
        ID_Access();
        openFragment(new Fragment_Home());
        navegation.setOnNavigationItemSelectedListener(Flink_Access.this);
    }
    // Associando id's
    private void ID_Access(){
        frame = findViewById(R.id.frame);
        navegation = findViewById(R.id.navegation);
    }

    // Bottom Navegation View
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.hom:
                Fragment hom = Fragment_Home.newInstance();
                openFragment(hom);
                break;

            case R.id.fav:
                Fragment fav = Fragment_Favorito.newInstance();
                openFragment(fav);
                break;

            case R.id.list:
                Fragment lis = Fragment_Lista.newInstance();
                openFragment(lis);
                break;

            case R.id.carr:
                Fragment car = Fragment_Carrinho.newInstance();
                openFragment(car);
                break;

            case R.id.perf:
                Fragment per = Fragment_Perfil.newInstance();
                openFragment(per);
                break;
        }
        return true;
    }

    // Evento ao chamar activity fragment
    private void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}