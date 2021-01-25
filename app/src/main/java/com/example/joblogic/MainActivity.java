package com.example.joblogic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Button buttonBuy, buttonCall, buttonSell;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonBuy = findViewById(R.id.button_buy);
        buttonSell = findViewById(R.id.button_sell);
        buttonCall = findViewById(R.id.button_call);

        buttonBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent buyIntent = new Intent(MainActivity.this, BuyActivity.class);
                startActivity(buyIntent);
            }
        });

        buttonCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(MainActivity.this, CallActivity.class);
                startActivity(callIntent);
            }
        });
    }
}