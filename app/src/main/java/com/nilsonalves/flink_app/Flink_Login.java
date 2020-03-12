package com.nilsonalves.flink_app;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.nilsonalves.flink_app.Util.SessionManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Flink_Login extends AppCompatActivity {

    private EditText phone;
    private EditText password;
    private Button entrar;
    private ProgressBar progress;
    private String url = "https://testeflink.000webhostapp.com/Conexao_mysql/Login.php";
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sessionManager = new SessionManager(this);

        coletar_ID();

        // Event de LOGIN
        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fone = phone.getText().toString().trim();
                String password = Flink_Login.this.password.getText().toString().trim();

                if (!fone.isEmpty()) {
                    if (!password.isEmpty()) {
                        progress.setVisibility(View.VISIBLE);
                        entrar.setVisibility(View.INVISIBLE);
                        login(fone, password);
                    } else {
                        Flink_Login.this.password.setError("Senha");
                    }
                } else {
                    phone.setError("Telefone");
                }
            }
        });
    }

    // Coleta de componentes por ID
    private void coletar_ID() {
        phone = findViewById(R.id.input_phone);
        password = findViewById(R.id.input_password);
        entrar = findViewById(R.id.entrar);
        progress = findViewById(R.id.progress);
    }

    // Consulta e validação de usuario para LOGIN do Banco de Dados
    private void login(final String fone, final String password) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            System.out.println("RESPONSE -----> " + response.replace("[", "").replace("]", ""));
                            System.out.println("RESPONSE -----> " + response);

                            if (!response.equalsIgnoreCase("[]")) {
                                JSONObject jsonObject = new JSONObject(response.replace("[", "").replace("]", ""));

                                // Valores consultados
                                String nome = jsonObject.getString("Nome").trim();
                                String tel = jsonObject.getString("Telefone").trim();
                                String passw = jsonObject.getString("Senha").trim();

                                // Valores Inseridos
                                String fone = phone.getText().toString().trim();
                                String password = Flink_Login.this.password.getText().toString().trim();

                                if (fone.equalsIgnoreCase(tel) && password.equalsIgnoreCase(passw)) {
                                    progress.setVisibility(View.GONE);
                                    entrar.setVisibility(View.VISIBLE);

                                    sessionManager.creatSession(nome, tel, passw);

                                    Intent intent = new Intent(getApplicationContext(), Flink_Access.class);
                                    Bundle bundle = new Bundle();
                                    bundle.putString("Nome", nome);
                                    bundle.putString("Telefone", tel);
                                    bundle.putString("Password", passw);
                                    startActivity(intent, bundle);
                                    finish();

                                } else {
                                    Toast.makeText(getApplicationContext(), "Olá " + nome + "\nParece que sua senha está errada!", Toast.LENGTH_LONG).show();
                                    progress.setVisibility(View.GONE);
                                    entrar.setVisibility(View.VISIBLE);
                                    Flink_Login.this.password.setError("Senha");
                                    Flink_Login.this.password.getText().clear();
                                }

                            } else {
                                Toast.makeText(getApplicationContext(), "Nenhum Usuário Encontrado", Toast.LENGTH_LONG).show();
                                progress.setVisibility(View.GONE);
                                entrar.setVisibility(View.VISIBLE);
                                phone.setError("Telefone");
                                phone.getText().clear();
                                phone.requestFocus();
                                Flink_Login.this.password.setError("Senha");
                                Flink_Login.this.password.getText().clear();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(), "Erro no Login " + e.toString(), Toast.LENGTH_LONG).show();
                            System.out.println("Erro Login JSON");
                            progress.setVisibility(View.GONE);
                            entrar.setVisibility(View.VISIBLE);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "Erro no Login " + error.toString(), Toast.LENGTH_LONG).show();
                        System.out.println("Erro Login RESPONSE");
                        progress.setVisibility(View.GONE);
                        entrar.setVisibility(View.VISIBLE);
                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("telefone", fone);
                params.put("password", password);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
