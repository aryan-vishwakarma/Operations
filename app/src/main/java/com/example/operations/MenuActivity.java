package com.example.operations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    TextView modulo, hcf, prime_checker, prime_factors, prime_factor_info
            ,prime_generator, prime_generator_info, prime_checker_info
            ,hcf_info, modulo_info;
    ImageView prime_factor_info_icon, prime_generator_info_icon
            ,prime_checker_info_icon, hcf_info_icon, modulo_info_icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        modulo = findViewById(R.id.menu_modulo);
        hcf = findViewById(R.id.menu_hcf);
        prime_checker = findViewById(R.id.menu_prime_checker);
        prime_factors = findViewById(R.id.menu_prime_factors);
        prime_factor_info_icon = findViewById(R.id.prime_factors_info_icon);
        prime_factor_info = findViewById(R.id.prime_factors_info_txt);
        prime_generator = findViewById(R.id.menu_prime_generator);
        prime_generator_info_icon = findViewById(R.id.prime_generator_info_icon);
        prime_generator_info = findViewById(R.id.prime_generator_info_txt);
        prime_checker_info_icon = findViewById(R.id.prime_checker_info_icon);
        prime_checker_info = findViewById(R.id.prime_checker_info_txt);
        hcf_info_icon = findViewById(R.id.hcf_info_icon);
        hcf_info = findViewById(R.id.hcf_info_txt);
        modulo_info_icon = findViewById(R.id.modulo_info_icon);
        modulo_info = findViewById(R.id.modulo_info_txt);

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

        prime_factors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (PrimeFactorsActivity.fa == null || PrimeFactorsActivity.fa.isFinishing()) {
                    startActivity(new Intent(MenuActivity.this, PrimeFactorsActivity.class));
                }
                finish();
            }
        });
        prime_factor_info_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (prime_factor_info.getVisibility() == View.GONE) {
                    prime_factor_info.setVisibility(View.VISIBLE);
                }
                else{
                    prime_factor_info.setVisibility(View.GONE);
                }
            }
        });
        prime_generator_info_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (prime_generator_info.getVisibility() == View.GONE) {
                    prime_generator_info.setVisibility(View.VISIBLE);
                }
                else{
                    prime_generator_info.setVisibility(View.GONE);
                }
            }
        });
        prime_checker_info_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (prime_checker_info.getVisibility() == View.GONE) {
                    prime_checker_info.setVisibility(View.VISIBLE);
                }
                else{
                    prime_checker_info.setVisibility(View.GONE);
                }
            }
        });
        hcf_info_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hcf_info.getVisibility() == View.GONE) {
                    hcf_info.setVisibility(View.VISIBLE);
                }
                else{
                    hcf_info.setVisibility(View.GONE);
                }
            }
        });
        modulo_info_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (modulo_info.getVisibility() == View.GONE) {
                    modulo_info.setVisibility(View.VISIBLE);
                }
                else{
                    modulo_info.setVisibility(View.GONE);
                }
            }
        });
    }
}