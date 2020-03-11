package com.nilsonalves.flink_app.Rede;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class Internet {

    public static boolean isConnected(Context context) {
        boolean rede = false;

        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivityManager != null) {
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

            if (networkInfo != null && networkInfo.isConnected()) {
                rede = true;
            }
        }
        return rede;
    }

    public static String tipoRede(Context context) {
        String tipo = "";
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if ( connectivityManager != null ) {
            connectivityManager.getActiveNetworkInfo();

            //Verifica internet pela WIFI
            if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnected()) {
                tipo = "Wifi";
            }

            //Verifica se tem internet móvel
            if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).isConnected()) {
                tipo = "Mobile";
            }
        }
        return tipo;
    }
}
