package com.nilsonalves.flink_app.Util;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.nilsonalves.flink_app.Flink_Access;
import com.nilsonalves.flink_app.Flink_Login;

import java.util.HashMap;

public class SessionManager {

    SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;
    public Context context;
    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "LOGIN";
    private static final String LOGIN = "IS_LOGIN";
    public static final String NOME = "NOME";
    public static final String TELEFONE = "TELEFONE";
    public static final String SENHA = "SENHA";


    public SessionManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("LOGIN", PRIVATE_MODE);
        editor = sharedPreferences.edit();
    }

    public void creatSession(String nome, String telefone, String email) {
        editor.putBoolean(LOGIN, true);
        editor.putString(NOME, nome);
        editor.putString(TELEFONE, telefone);
        editor.putString(SENHA, email);
        editor.apply();
    }

    public boolean isLogin() {
        return sharedPreferences.getBoolean(LOGIN, false);
    }

    public void checkLogin() {
        if (!this.isLogin()) {
            Intent intent = new Intent(context, Flink_Login.class);
            context.startActivity(intent);
            ((Flink_Login) context).finish();
        }
    }

    public HashMap<String, String> getUserDetail() {
        HashMap<String, String> user = new HashMap<>();
        user.put(NOME, sharedPreferences.getString(NOME, null));
        user.put(TELEFONE, sharedPreferences.getString(TELEFONE, null));
        user.put(SENHA, sharedPreferences.getString(SENHA, null));

        return user;
    }

    public void logout() {
        editor.clear();
        editor.commit();
        Intent intent = new Intent(context, Flink_Login.class);
        context.startActivity(intent);
        ((Flink_Access) context).finish();
    }
}
