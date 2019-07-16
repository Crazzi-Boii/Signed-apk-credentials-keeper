package com.example.myapplicationtest;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button b;
    TextView t;
    EditText e;
    RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup =findViewById(R.id.radio);
        e = findViewById(R.id.editText);
        b = findViewById(R.id.bu);
        t = findViewById(R.id.textView);

    }


    public void lolo(View view) {
        int _pass_len = 0;
        //Toast.makeText(this, String.valueOf(radioGroup.getCheckedRadioButtonId()), Toast.LENGTH_SHORT).show();
        //Log.e("****",String.valueOf(radioGroup.getCheckedRadioButtonId()));
            switch (radioGroup.getCheckedRadioButtonId()) {
                case 2131165279:
                    _pass_len = 8;
                    break;
                case 1:
                    _pass_len = 16;
                    break;
                case 2:
                    _pass_len = 21;
                    break;
            }
            generate(_pass_len);

    }

    private void generate(int _len) {
        Toast.makeText(this, "" + _len, Toast.LENGTH_SHORT).show();
        switch (_len){
            case 8:
                getMixedString(_len/2);
                break;
            case 16:
                getMixedString(_len/2);
                break;
            case 21:
                getMixedString(_len/2);
                break;
        }

        Random r = new Random();
        String i = String.valueOf(r.nextInt(9999 - 1111) + 1111);
        String name = e.getText().toString();
        String p = name +"@#" + i + "$!";
        t.setText(p);

    }

    private void getMixedString(int i) {
        Random r = new Random();
        for (int a=0; a<(90-65);a++ ){
            //65 - 90 A-Z
            int ascii = r.nextInt(91 - 65) + 65;
            char am = (char)ascii;
            Log.e(a + "" , ""+am);
        }
        for (int a=0; a<i/2;a++ ){
            //97-122 a-z
        }
    }
}
