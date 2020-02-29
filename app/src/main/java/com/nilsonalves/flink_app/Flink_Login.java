package com.nilsonalves.flink_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.QuickContactBadge;
import android.widget.Toast;

public class Flink_Login extends AppCompatActivity {

    private EditText telefone;
    private EditText senha;
    private Button entrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        coletar_ID();

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Telefone: " + telefone.getText() + "\nSenha: " + senha.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void coletar_ID() {
        telefone = findViewById(R.id.telefone);
        senha = findViewById(R.id.senha);
        entrar = findViewById(R.id.entrar);
    }
}
