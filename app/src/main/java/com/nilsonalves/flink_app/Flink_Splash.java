package com.nilsonalves.flink_app;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.nilsonalves.flink_app.Rede.Internet;
import com.nilsonalves.flink_app.Util.SessionManager;

public class Flink_Splash extends AppCompatActivity {

    private TextView txt_verificRede;
    private ProgressBar progress_splash;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        txt_verificRede = findViewById(R.id.txt_verificRede);
        progress_splash = findViewById(R.id.progress_splash);

        inspect();
//        atalhoTeste();

    }

    private void atalhoTeste(){
        Intent lista = new Intent(Flink_Splash.this,Flink_Lista.class);
        startActivity(lista);
    }

    private void inspect() {
        sessionManager = new SessionManager(this);
        boolean isLogado = sessionManager.isLogin();
        boolean rede = Internet.isConnected(getApplicationContext());

        if (isLogado) {
            if (rede) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        isConnectLogado();
                    }
                }, 1000);

            } else {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        notConnect();
                    }
                }, 1000);
            }
        } else {
            if (rede) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        isConnectNotLogado();
                    }
                }, 1000);

            } else {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        notConnect();
                    }
                }, 1000);
            }
        }
    }

    private void isConnectLogado() {
        txt_verificRede.setText("Acesso a Internet");
        progress_splash.setVisibility(View.GONE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), Flink_Inicio.class);
                startActivity(intent);
                finish();
            }
        }, 1000);
    }

    private void isConnectNotLogado() {
        txt_verificRede.setText("Acesso a Internet");
        progress_splash.setVisibility(View.GONE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), Flink_Login.class);
                startActivity(intent);
                finish();
            }
        }, 1000);
    }

    private void notConnect() {
        txt_verificRede.setText("Sem acesso a Internet. Repetir");
        progress_splash.setVisibility(View.GONE);
        txt_verificRede.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progress_splash.setVisibility(View.VISIBLE);
                txt_verificRede.setText("Verificando Rede...");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        boolean repet = Internet.isConnected(getApplicationContext());
                        if (repet) {
                            isConnectLogado();
                        } else {
                            txt_verificRede.setText("Sem acesso a Internet. Repetir");
                            progress_splash.setVisibility(View.GONE);
                        }

                    }
                }, 1000);

            }
        });
    }

}
