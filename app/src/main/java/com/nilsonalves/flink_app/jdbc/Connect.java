package com.nilsonalves.flink_app.jdbc;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Connect {

    private static String url = "https://testeflink.000webhostapp.com/Conexao_mysql/Connect.php";
    private static StringRequest stringRequest;
    private static RequestQueue requestQueue;

    public static void conn(Context context) {
        requestQueue = Volley.newRequestQueue(context);

    }

    public static void test(final String nome, final String localizacao) {

        stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.v("MENSAGEM ------ ", response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.v("ERRO ----- ", error.getMessage());
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> param = new HashMap<>();
                param.put("Nome", nome);
                param.put("Localizacao", localizacao);
                return param;
            }
        };

        requestQueue.add(stringRequest);
    }
}
