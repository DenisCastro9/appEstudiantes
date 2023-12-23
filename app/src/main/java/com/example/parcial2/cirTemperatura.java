package com.example.parcial2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class cirTemperatura extends AppCompatActivity {
    private Temperatura tem1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cir_temperatura);
        tem1 = findViewById(R.id.tem1);
    }


    public void subir (View v)
    {
        tem1.subirt();
    }
}