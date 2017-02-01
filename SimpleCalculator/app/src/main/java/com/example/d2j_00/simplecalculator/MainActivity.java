package com.example.d2j_00.simplecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculate(View view){
        EditText num1 = (EditText) findViewById(R.id.num1);
        EditText num2 = (EditText) findViewById(R.id.num2);
        TextView resulst = (TextView) findViewById(R.id.result);
        RadioGroup operator = (RadioGroup) findViewById(R.id.operator);

        double angka1, angka2, hasil = 0;
        angka1 = Double.parseDouble(num1.getText().toString());
        angka2 = Double.parseDouble(num2.getText().toString());
        int opr = operator.getCheckedRadioButtonId();

        if(opr == R.id.plus) {
            hasil = angka1 + angka2;
        }else if(opr == R.id.minus){
            hasil = angka1 - angka2;
        }
        if(opr == R.id.kali) {
            hasil = angka1 * angka2;
        }else if(opr == R.id.bagi){
            hasil = angka1 / angka2;
        }
resulst.setText(Double.toString(hasil));
    }
}
