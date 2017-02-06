package rian.pratama.tipscalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void hitung(View view) {
        EditText input1 = (EditText) findViewById(R.id.input1);
        EditText input2 = (EditText) findViewById(R.id.input2);
        EditText input3 = (EditText) findViewById(R.id.input3);

        String hasil = "";
        double Inp1, Inp2, Inp3;
        Inp1 = Double.parseDouble(input1.getText().toString());
        Inp2 = Double.parseDouble(input2.getText().toString());
        Inp3 = Double.parseDouble(input3.getText().toString());

        hasil = "tip = " + (Inp1 * Inp2) / 100 + "\n";
        hasil += "Total = " + (Inp1 + ((Inp1 * Inp2 / 100)) / Inp3) + "\n";
        hasil += "Perorang = "+((Inp1+ ((Inp1 * Inp2) / 100)) /Inp3)+ "\n";
        TextView result = (TextView) findViewById(R.id.result);
        result.setText(hasil);

    }

}
