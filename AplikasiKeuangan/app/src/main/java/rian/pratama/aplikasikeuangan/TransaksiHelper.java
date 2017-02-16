package rian.pratama.aplikasikeuangan;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by D2J-00 on 13/02/2017.
 */
public class TransaksiHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "keuangan.db";
    public static final int DB_VERSION = 6;

    SQLiteDatabase db;

    public TransaksiHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Transaksi.SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(Transaksi.SQL_DELETE);
        onCreate(db);
    }
    public void insertTransaksi(String nama, int jenis, int jumlah, String keterangan){
        db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Transaksi.COL_NAMA, nama);
        values.put(Transaksi.COL_JENIS, jenis);
        values.put(Transaksi.COL_JUMLAH, jumlah);
        if (keterangan == null)
            keterangan = "";

        values.put(Transaksi.COL_KETERANGAN, keterangan);
        db.insert(Transaksi.TABLE_NAME, null, values);
    }

    public List<Transaksi> getTransaksi(){
        db = getReadableDatabase();
        List<Transaksi> transaksi = new ArrayList<>();
        String [] projection = {Transaksi._ID, Transaksi.COL_NAMA, Transaksi.COL_JENIS,
                                Transaksi.COL_JUMLAH, Transaksi.COL_KETERANGAN};
        String sortOrder = Transaksi._ID;

        Cursor cursor = db.query(Transaksi.TABLE_NAME, projection,null,null,null,null, sortOrder);

        Transaksi newTrans;
        while (cursor.moveToNext()) {
            newTrans = new Transaksi(
                    cursor.getString(cursor.getColumnIndex(Transaksi.COL_NAMA)),
                    cursor.getInt(cursor.getColumnIndex(Transaksi.COL_JENIS)),
                    cursor.getInt(cursor.getColumnIndex(Transaksi.COL_JUMLAH)),
                    cursor.getString(cursor.getColumnIndex(Transaksi.COL_KETERANGAN)) );

            transaksi.add(newTrans);
        }
        cursor.close();
        return transaksi;
    }
}
