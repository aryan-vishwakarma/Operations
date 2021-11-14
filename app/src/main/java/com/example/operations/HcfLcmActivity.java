package com.example.operations;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.TextView;

public class HcfLcmActivity extends AppCompatActivity {

    HorizontalScrollView scrollView;
    public static Activity fa;

    String TAG = "HCF and LCM Activity";

    Button one, two, three, four, five, six, seven ,
            eight, nine, zero, comma, equal, c_btn;

    ImageButton bks_btn, menu_btn;

    TextView exp, hcf_ans, lcm_ans;

    long[] number_array;
    int n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hcf_lcm);

        fa = this;
        try{
        ModuloActivity.fa.finish();
        }
        catch (Exception ignored){}
        try {
            PrimeCheckActivity.fa.finish();
        }
        catch (Exception ignored){}

        scrollView = findViewById(R.id.scroll_view_hcf);

        one = findViewById(R.id.hcf_one_btn);
        two = findViewById(R.id.hcf_two_btn);
        three = findViewById(R.id.hcf_three_btn);
        four = findViewById(R.id.hcf_four_btn);
        five = findViewById(R.id.hcf_five_btn);
        six = findViewById(R.id.hcf_six_btn);
        seven = findViewById(R.id.hcf_seven_btn);
        eight = findViewById(R.id.hcf_eight_btn);
        nine = findViewById(R.id.hcf_nine_btn);
        zero = findViewById(R.id.hcf_zero_btn);
        comma = findViewById(R.id.hcf_comma_btn);
        equal = findViewById(R.id.hcf_equal_btn);
        c_btn = findViewById(R.id.hcf_c_btn);
        bks_btn = findViewById(R.id.hcf_bks_btn);
        menu_btn = findViewById(R.id.pc_menu_btn);
        exp = findViewById(R.id.hcf_exp);
        hcf_ans = findViewById(R.id.hcf_ans_hcf);
        lcm_ans = findViewById(R.id.hcf_ans_lcm);

        number_array = new long[50];
        n=0;

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
        comma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setText(',');
                setText(' ');
            }
        });
        c_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp.setText(null);
                hcf_ans.setText(null);
                lcm_ans.setText(null);
            }
        });
        bks_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = exp.getText().toString();
                int l = str.length();
                if (l != 0) {
                    if (str.charAt(l - 1) == ' ') {
                        str = str.substring(0, l - 2);
                    } else {
                        str = str.substring(0, l - 1);
                    }
                    exp.setText(str);
                }
                hcf_ans.setText(null);
                lcm_ans.setText(null);
            }
        });
        menu_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HcfLcmActivity.this, MenuActivity.class));
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    solve();
                }
                catch (Exception exception) {
                    hcf_ans.setText("Error...");
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(HcfLcmActivity.this, MenuActivity.class));
        finish();
    }

    private void makeScrollRight(){
        try {
            scrollView.post(new Runnable() {
                @Override
                public void run() {
                    scrollView.fullScroll(View.FOCUS_RIGHT);
                }
            });
        }
        catch (Exception e) {
            Log.d(TAG, "makeScrollRight: Exception " + e.toString());
        }
    }

    private void setText(char ch){
        String str = exp.getText().toString();
        str += ch;
        exp.setText(str);
        makeScrollRight();
    }

    private void solve(){
        if (exp.getText().length() != 0) {
            n = 0;
            extractNumbers();
            if (n == 1) {
                hcf_ans.setText(getString(R.string.hcf_ans, String.valueOf(number_array[0])));
                lcm_ans.setText(getString(R.string.lcm_ans, String.valueOf(number_array[0])));
            }
            else {
                Log.d(TAG, "solve: n = " + n);
                long hcf = hcfOfTwo(number_array[0], number_array[1]);
                for (int i = 2; i < n; i++){
                    hcf = hcfOfTwo(hcf, number_array[i]);
                }
                hcf_ans.setText(getString(R.string.hcf_ans, String.valueOf(hcf)));
                long lcm = (number_array[0] * number_array[1]) / hcfOfTwo(number_array[0], number_array[1]);
                for (int i = 2; i < n; i++){
                    Log.d(TAG, "solve: number_array[" + i + "] = " + number_array[i]);
                    lcm = (lcm * number_array[i]) / hcfOfTwo(lcm, number_array[i]);
                    Log.d(TAG, "solve: loop lcm = " + lcm);
                }
                Log.d(TAG, "solve: lcm = " + lcm);
                lcm_ans.setText(getString(R.string.lcm_ans, String.valueOf(lcm)));
            }
        }
    }

    private void extractNumbers(){
        String str = exp.getText().toString();
        StringBuilder s = new StringBuilder();
        int l = str.length();
        if (str.charAt(l-1) != ' '){
            str += ',';
        }
        for (int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ','){
                number_array[n++] = Long.parseLong(s.toString());
                i++;
                s = new StringBuilder();
            }
            else {
                s.append(str.charAt(i));
            }
        }
    }

    private long hcfOfTwo(long firstNumber, long secondNumber){
        long smaller = Math.min(firstNumber, secondNumber);
        long greater = Math.max(firstNumber, secondNumber);
        long rem = greater % smaller;
        if (rem == 0){
            return smaller;
        }
        else{
            return hcfOfTwo(smaller, rem);
        }
    }
}