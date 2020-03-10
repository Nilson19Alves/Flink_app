package com.nilsonalves.flink_app.jdbc;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.nilsonalves.flink_app.fragments.Fragment_Home;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class TaskBD extends AsyncTask<String, Integer, String> {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... strings) {
        String stringURL = strings[0];

        InputStream inputStream = null;
        StringBuffer stringBuffer = null;


        try {
            URL url = new URL(stringURL);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

            inputStream = conexao.getInputStream();

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            stringBuffer = new StringBuffer();
            String linha = "";
            while ((linha = bufferedReader.readLine()) != null){
                stringBuffer.append(linha);
            }
            //Log.d("saida ", stringBuffer.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuffer.toString();
    }

    @Override
    protected void onPostExecute(String s) {

    }
}
