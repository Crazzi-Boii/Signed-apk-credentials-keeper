package com.example.myapplicationtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

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
        //Toast.makeText(this, "" + _len, Toast.LENGTH_SHORT).show();
        String _password="";
        switch (_len){
            case 8:
                _password = getMixedString(_len/2);
                break;
            case 16:
                _password = getMixedString(_len/2);
                break;
            case 21:
                _password = getMixedString(_len/2);
                break;
        }

        t.setText(_password);

    }

    private String getMixedString(int i) {
        Random r = new Random();
        String[] _pass1,_pass2, _pass3, _pass4;
        String _pass="";
        _pass1 = new String[i/2];
        _pass2 = new String[i/2];
        _pass3 = new String[i/2];
        _pass4 = new String[i/2];
        String symbols = "!@#$%^&*_=+-/.?<>)";

        for (int a=0; a<i/2;a++ ){
            //65 - 90 A-Z
            int ascii = r.nextInt(91 - 65) + 65;
            char am = (char)ascii;
            _pass1[a] = String.valueOf(am);
            //97-122 a-z
            ascii = r.nextInt(123 - 97) + 97;
            am = (char)ascii;
            _pass2[a] = String.valueOf(am);
            //Generate number
            _pass3[a] = String.valueOf(r.nextInt(10 - 1) + 1);
            //Generate a Symbol
            _pass4[a] = String.valueOf(symbols.charAt(r.nextInt(symbols.length())));
            //Generates final password
            _pass = _pass + _pass1[a] + _pass3[a] + _pass2[a] + _pass4[a];
        }
        //Log.e("PASS",_pass);
        return _pass;
    }
}
