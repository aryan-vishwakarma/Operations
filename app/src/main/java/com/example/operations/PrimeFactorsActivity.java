package com.example.operations;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedHashMap;
import java.util.Map;

public class PrimeFactorsActivity extends AppCompatActivity {

    String TAG = "Prime Factor Activity";
    public static Activity fa;

    Button one, two, three, four, five, six, seven ,
            eight, nine, zero, equal, c_btn;

    ImageButton bks_btn, menu_btn;

    TextView number, answer;
    Map<Long, Integer> factors;
    PrimeFactors primeFactors;
    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prime_factors);

        fa = this;
        try {
            ModuloActivity.fa.finish();
        } catch (Exception ignored) {}
        try {
            HcfLcmActivity.fa.finish();
        } catch (Exception ignored) {}
        try {
            PrimeCheckActivity.fa.finish();
        } catch (Exception ignored) {}

        one = findViewById(R.id.pc_one_btn);
        two = findViewById(R.id.pc_two_btn);
        three = findViewById(R.id.pc_three_btn);
        four = findViewById(R.id.pc_four_btn);
        five = findViewById(R.id.pc_five_btn);
        six = findViewById(R.id.pc_six_btn);
        seven = findViewById(R.id.pc_seven_btn);
        eight = findViewById(R.id.pc_eight_btn);
        nine = findViewById(R.id.pc_nine_btn);
        zero = findViewById(R.id.pc_zero_btn);
        equal = findViewById(R.id.pc_equal_btn);
        c_btn = findViewById(R.id.pc_c_btn);
        bks_btn = findViewById(R.id.pc_bks_btn);
        menu_btn = findViewById(R.id.pc_menu_btn);
        number = findViewById(R.id.pc_exp);
        answer = findViewById(R.id.pf_answer);
        scrollView = findViewById(R.id.scroll_view);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setText('1');
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setText('2');
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setText('3');
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setText('4');
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setText('5');
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setText('6');
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setText('7');
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setText('8');
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setText('9');
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setText('0');
            }
        });
        c_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number.setText(null);
                answer.setText(null);
                scrollView.setBackground(null);
            }
        });
        bks_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = number.getText().toString();
                int l = str.length();
                if (l != 0) {
                    str = str.substring(0, l - 1);
                    number.setText(str);
                }
                answer.setText(null);
                scrollView.setBackground(null);
            }
        });
        menu_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PrimeFactorsActivity.this, MenuActivity.class));
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (number.getText().length() != 0) {
                    primeFactors = new PrimeFactors();
                    factors = new LinkedHashMap<>();
                    factors = primeFactors.findPrimeFactors(Long.parseLong(number.getText().toString()));
                    setAnswer();
                }
            }
        });
    }

    private void setAnswer(){
        String str = "The Prime factors are:\n";
        for (Map.Entry<Long, Integer> m : factors.entrySet()) {
            if (m.getValue() == 1){
                str += "     " + m.getKey() + "\n";
            } else {
                str += "     " + m.getKey() + "  ^  " + m.getValue() + "\n";
            }
            Log.d(TAG, "setAnswer: str = " + str);
        }
        str = str.substring(0, str.length() - 1);
        Log.d(TAG, "setAnswer: str finally : "+ str);
        answer.setText(str);
        scrollView.setBackground(AppCompatResources.getDrawable(this, R.drawable.text_background_plain));
    }

    private void setText(char ch){
        String str = number.getText().toString();
        if (str.length() <= 10) {
            str += ch;
            number.setText(str);
            answer.setText(null);
            scrollView.setBackground(null);
        }
        else{
            Toast.makeText(PrimeFactorsActivity.this, "Number is too long", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(PrimeFactorsActivity.this, MenuActivity.class));
        finish();
    }
}