package com.nilsonalves.flink_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
                Intent intent = new Intent(getApplicationContext(), Flink_Home.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void coletar_ID() {
        telefone = findViewById(R.id.telefone);
        senha = findViewById(R.id.senha);
        entrar = findViewById(R.id.entrar);
    }
}
