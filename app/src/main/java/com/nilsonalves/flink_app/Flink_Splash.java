package com.nilsonalves.flink_app;

import android.content.Intent;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.nilsonalves.flink_app.jdbc.Connect_Remot;

public class Flink_Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //Connect_Remot.connection();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), Flink_Login.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }
}
