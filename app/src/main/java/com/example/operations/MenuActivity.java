package com.example.operations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    TextView modulo, hcf, prime_checker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        modulo = findViewById(R.id.menu_modulo);
        hcf = findViewById(R.id.menu_hcf);
        prime_checker = findViewById(R.id.menu_prime_checker);

        modulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ModuloActivity.fa == null || ModuloActivity.fa.isFinishing()) {
                    startActivity(new Intent(MenuActivity.this, ModuloActivity.class));
                }
                finish();
            }
        });

        hcf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (HcfLcmActivity.fa == null || HcfLcmActivity.fa.isFinishing()) {
                    startActivity(new Intent(MenuActivity.this, HcfLcmActivity.class));
                }
                finish();
            }
        });

        prime_checker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (PrimeCheckActivity.fa == null || PrimeCheckActivity.fa.isFinishing()) {
                    startActivity(new Intent(MenuActivity.this, PrimeCheckActivity.class));
                }
                finish();
            }
        });
    }
}