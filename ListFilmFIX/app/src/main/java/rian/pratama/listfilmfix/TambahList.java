package rian.pratama.listfilmfix;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class TambahList extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String [] Rating = {"5.5","6.0","6.5","7.0","7.5","8.0","8.5","9.0","9.5"};
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_list);

        Spinner pilihrating = (Spinner) findViewById(R.id.pilihrating);
        ArrayAdapter<String> adapter = new  ArrayAdapter<String>(this,
                                        android.R.layout.simple_spinner_item, Rating);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pilihrating.setAdapter(adapter);
    }

    public void addfilm (View view){
        String title = ((EditText) findViewById(R.id.inputjudul)).getText().toString();
        int tahun = Integer.parseInt(((EditText) findViewById(R.id.inputtahun)).getText().toString());
        double rating = Double.parseDouble(((Spinner) findViewById(R.id.pilihrating)).getSelectedItem().toString());

        String deskripsi = ((EditText) findViewById(R.id.inputdeskripsi)).getText().toString();

            Movie movie = new Movie(title, deskripsi, rating, tahun);

            Intent intent = new Intent();
            intent.putExtra("listfilmfix.result     ", movie);
            setResult(Activity.RESULT_OK, intent);
            finish();
    }
}
