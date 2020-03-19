package com.nilsonalves.flink_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class FeedTeste extends AppCompatActivity {

    private TextView result_qrcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_teste);

        result_qrcode = findViewById(R.id.result_qrcode);

        Bundle bundle = getIntent().getExtras();
        String result = "Resultado do QR CODE: " + bundle.getString("QR_Code");
        result_qrcode.setText(result);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), Flink_Inicio.class);
        startActivity(intent);
        finish();
    }
}
