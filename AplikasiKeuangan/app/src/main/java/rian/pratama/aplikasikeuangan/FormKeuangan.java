package rian.pratama.aplikasikeuangan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class  FormKeuangan extends AppCompatActivity {

    private String [] jenis = {"Pemasukan","Pengeluaran"};
    private EditText edtNama,edtJumlah,edtKeterangan;
    private Spinner pilijenis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_keuangan);

    pilijenis = (Spinner) findViewById(R.id.pilijenis);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,jenis);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pilijenis.setAdapter(adapter);

        edtNama = (EditText)findViewById(R.id.inputnama);
        edtJumlah = (EditText)findViewById(R.id.inputjumlah);
        edtKeterangan = (EditText) findViewById(R.id.inputketerangan);
    }
    public void saveTransaksi(View view){
            TransaksiHelper dbHelper = new TransaksiHelper(this);
            String nama = edtNama.getText().toString();
            int jenis = pilijenis.getSelectedItemPosition()+1;
            int jumlah = Integer.parseInt(edtJumlah.getText().toString());
            String keterangan = edtKeterangan.getText().toString();

            dbHelper.insertTransaksi(nama, jenis, jumlah, keterangan);
        Log.d("form transaksi",nama+"-"+Integer.toString(jenis)+" - "+Integer.toString(jumlah)+" - "+keterangan);
        Toast.makeText(this, "Transaksi"+nama+"berhasil disimpan", Toast.LENGTH_SHORT).show();
        finish();
    }
}
