package com.example.operations;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView expression, modulo, selected, answer;
    Button c_btn, exp_bnt, div_btn, seven_btn, eight_btn,
    nine_btn, four_btn, five_btn, six_btn, one_btn, two_btn,
    three_btn, zero_btn, equal_btn, fac_btn, plus_btn, sub_btn,
    mul_btn, open_brac, closed_brac;
    ImageButton bks_btn;
    long ans;

    ModuloOperation moduloOperation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expression = findViewById(R.id.modulo_expression);
        modulo = findViewById(R.id.modulo_modulo);

        c_btn = findViewById(R.id.modulo_c_btn);
        exp_bnt = findViewById(R.id.modulo_exp_btn);
        div_btn = findViewById(R.id.modulo_div_btn);
        seven_btn = findViewById(R.id.modulo_seven_btn);
        eight_btn = findViewById(R.id.modulo_eight_btn);
        nine_btn = findViewById(R.id.modulo_nine_btn);
        one_btn = findViewById(R.id.modulo_one_btn);
        zero_btn = findViewById(R.id.modulo_zero_btn);
        two_btn = findViewById(R.id.modulo_two_btn);
        three_btn = findViewById(R.id.modulo_three_btn);
        four_btn = findViewById(R.id.modulo_four_btn);
        five_btn = findViewById(R.id.modulo_five_btn);
        six_btn = findViewById(R.id.modulo_six_btn);
        equal_btn = findViewById(R.id.modulo_equal_btn);
        fac_btn = findViewById(R.id.modulo_fac_btn);
        plus_btn = findViewById(R.id.modulo_plus_btn);
        sub_btn = findViewById(R.id.modulo_sub_btn);
        mul_btn = findViewById(R.id.modulo_mul_btn);
        bks_btn = findViewById(R.id.modulo_bks_btn);
        answer = findViewById(R.id.modulo_answer);
        open_brac = findViewById(R.id.modulo_open_bracket);
        closed_brac = findViewById(R.id.modulo_closed_bracket);

        moduloOperation = new ModuloOperation();

        selected = expression;
        selected.setBackground(AppCompatResources.getDrawable(this, R.drawable.text_background));

        expression.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected = expression;
                selected.setBackground(AppCompatResources.getDrawable(MainActivity.this, R.drawable.text_background));
                modulo.setBackground(null);
                enable();
            }
        });
        modulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected = modulo;
                selected.setBackground(AppCompatResources.getDrawable(MainActivity.this, R.drawable.text_background));
                expression.setBackground(null);
                disable();
            }
        });

        c_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected.setText(null);
                answer.setText(null);
            }
        });
        exp_bnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = selected.getText().toString();
                str = str + "^";
                selected.setText(str);
            }
        });
        bks_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = selected.getText().toString();
                if(str.length() != 0)
                str = str.substring(0,str.length() - 1);
                selected.setText(str);
            }
        });
        div_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = selected.getText().toString();
                str = str + "/";
                selected.setText(str);
            }
        });
        seven_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = selected.getText().toString();
                str = str + "7";
                selected.setText(str);
            }
        });
        eight_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = selected.getText().toString();
                str = str + "8";
                selected.setText(str);
            }
        });
        nine_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = selected.getText().toString();
                str = str + "9";
                selected.setText(str);
            }
        });
        mul_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = selected.getText().toString();
                str = str + "*";
                selected.setText(str);
            }
        });
        four_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = selected.getText().toString();
                str = str + "4";
                selected.setText(str);
            }
        });
        five_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = selected.getText().toString();
                str = str + "5";
                selected.setText(str);
            }
        });
        six_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = selected.getText().toString();
                str = str + "6";
                selected.setText(str);
            }
        });
        sub_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = selected.getText().toString();
                str = str + "-";
                selected.setText(str);
            }
        });
        one_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = selected.getText().toString();
                str = str + "1";
                selected.setText(str);
            }
        });
        two_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = selected.getText().toString();
                str = str + "2";
                selected.setText(str);
            }
        });
        three_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = selected.getText().toString();
                str = str + "3";
                selected.setText(str);
            }
        });
        plus_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = selected.getText().toString();
                str = str + "+";
                selected.setText(str);
            }
        });
        zero_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = selected.getText().toString();
                str = str + "0";
                selected.setText(str);
            }
        });
        fac_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = selected.getText().toString();
                str = str + "!";
                selected.setText(str);
            }
        });
        open_brac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = selected.getText().toString();
                str = str + "(";
                selected.setText(str);
            }
        });
        closed_brac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = selected.getText().toString();
                str = str + ")";
                selected.setText(str);
            }
        });
        equal_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(expression.getText().length() == 0){
                    selected = expression;
                    selected.setBackground(AppCompatResources.getDrawable(MainActivity.this, R.drawable.text_background));
                    modulo.setBackground(null);
                    enable();
                }
                else if(modulo.getText().length() == 0){
                    selected = modulo;
                    selected.setBackground(AppCompatResources.getDrawable(MainActivity.this, R.drawable.text_background));
                    expression.setBackground(null);
                    disable();
                }
                else{
                    try {
                        ans = moduloOperation.calculate(expression.getText().toString(), Long.parseLong(modulo.getText().toString()));
                        answer.setText(String.valueOf(ans));
                    }
                    catch (Exception e){
                        answer.setText("Error...");
                    }
                }
            }
        });
    }
    private void disable(){
        exp_bnt.setEnabled(false);
        exp_bnt.setTextColor(getColor(R.color.faint_orange));
        div_btn.setEnabled(false);
        div_btn.setTextColor(getColor(R.color.faint_orange));
        mul_btn.setEnabled(false);
        mul_btn.setTextColor(getColor(R.color.faint_orange));
        open_brac.setEnabled(false);
        open_brac.setTextColor(getColor(R.color.faint_orange));
        closed_brac.setEnabled(false);
        closed_brac.setTextColor(getColor(R.color.faint_orange));
        fac_btn.setEnabled(false);
        fac_btn.setTextColor(getColor(R.color.faint_orange));
        sub_btn.setEnabled(false);
        sub_btn.setTextColor(getColor(R.color.faint_orange));
        plus_btn.setEnabled(false);
        plus_btn.setTextColor(getColor(R.color.faint_orange));
    }
    private void enable(){
        exp_bnt.setEnabled(true);
        exp_bnt.setTextColor(getColor(R.color.orange));
        div_btn.setEnabled(true);
        div_btn.setTextColor(getColor(R.color.orange));
        mul_btn.setEnabled(true);
        mul_btn.setTextColor(getColor(R.color.orange));
        open_brac.setEnabled(true);
        open_brac.setTextColor(getColor(R.color.orange));
        closed_brac.setEnabled(true);
        closed_brac.setTextColor(getColor(R.color.orange));
        fac_btn.setEnabled(true);
        fac_btn.setTextColor(getColor(R.color.orange));
        sub_btn.setEnabled(true);
        sub_btn.setTextColor(getColor(R.color.orange));
        plus_btn.setEnabled(true);
        plus_btn.setTextColor(getColor(R.color.orange));
    }
}