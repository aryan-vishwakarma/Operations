package com.example.operations;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class PrimeCheckActivity extends AppCompatActivity {

    String TAG = "Prime Checker Activity";
    public static Activity fa;

    Button one, two, three, four, five, six, seven ,
            eight, nine, zero, equal, c_btn;

    ImageButton bks_btn, menu_btn;

    TextView number, is_prime_ans, next_prime, previous_prime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prime_check);

        fa = this;
        try {
            ModuloActivity.fa.finish();
        } catch (Exception ignored) {}
        try {
            HcfLcmActivity.fa.finish();
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
        is_prime_ans = findViewById(R.id.is_prime);
        next_prime = findViewById(R.id.next_prime);
        previous_prime = findViewById(R.id.previous_prime);

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
                is_prime_ans.setText(null);
                next_prime.setText(null);
                previous_prime.setText(null);
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
                is_prime_ans.setText(null);
                next_prime.setText(null);
                previous_prime.setText(null);
            }
        });
        menu_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PrimeCheckActivity.this, MenuActivity.class));
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = number.getText().toString();
                if (str.length() != 0) {
                    long num = Long.parseLong(str);
                    if (isPrime(num)){
                        is_prime_ans.setText("Yes, it's Prime");
                    }
                    else {
                        is_prime_ans.setText("No, it's not a Prime");
                    }
                    next_prime.setText(getString(R.string.next_prime, nextPrime(num)));
                    long prev_pr = previousPrime(num);
                    if (prev_pr != -1) {
                        previous_prime.setText(getString(R.string.previous_prime, previousPrime(num)));
                    }
                    else{
                        previous_prime.setText(getText(R.string.no_previous_prime));
                    }
                }
            }
        });
    }
    private void setText(char ch) {
        String str = number.getText().toString();
        str+=ch;
        number.setText(str);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(PrimeCheckActivity.this, MenuActivity.class));
        finish();
    }

    private boolean isPrime(long num){
        if(num == 0){
            return false;
        }
        if (num == 1){
            return false;
        }
        if (num == 2 || num == 3){
            return true;
        }
        if (num % 6 != 1 && num % 6 != 5){
            return false;
        }
        int flag = 0;
        for (int i = 2; i < Math.sqrt(num) + 1; i++){
            if (num % i == 0){
                flag = 1;
                break;
            }
        }
        return flag == 0;
    }
    private long nextPrime(long num) {
        int i = 1;
        while (true){
            if(isPrime(num + i)){
                return num + i;
            }
            i++;
        }
    }
    private long previousPrime(long num) {
        int i = 1;
        while (num - i > 0) {
            if(isPrime(num - i)){
                return num - i;
            }
            i++;
        }
        return  -1;
    }
}