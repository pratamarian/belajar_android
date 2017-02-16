package rian.pratama.aplikasikeuangan;

import android.provider.BaseColumns;

import java.io.Serializable;

/**
 * Created by D2J-00 on 13/02/2017.
 */
public class Transaksi implements BaseColumns,Serializable {
    public String nama ; //nama transaksi
    public int jenis ; // 1=pemasukan 2=pengeluaran
    public int jumlah;
    public String keterangan;

    public Transaksi(String nama, int jenis, int jumlah) {
        this.nama = nama;
        this.jenis = jenis;
        this.jumlah = jumlah;
    }

    public Transaksi(String nama, int jenis, int jumlah, String keterangan) {
        this.nama = nama;
        this.jenis = jenis;
        this.jumlah = jumlah;
        this.keterangan = keterangan;
    }

    public String getJenis(){
        if (this.jenis == 1)
            return "pemasukan";
        return "pengeluaran";
    }

    @Override
    public  String toString(){
        return this.nama+": "+this.jumlah;
    }

    /*informasi properti label*/
    public static final String TABLE_NAME = "transaksi";
    public static final String COL_NAMA = "name";
    public static final String COL_JENIS = "type";
    public static final String COL_JUMLAH = "amount";
    public static final String COL_KETERANGAN = "keterangan";

    /* query pembuatan dan penghapusan tabel*/
    /* create table transaksi (id integer primary_key, name text, jenis integer, jumlah integer, keterangan text) */

    public static final String SQL_CREATE = "create table "+TABLE_NAME
            +" ("+_ID+" interger primary_key,"
            +" "+COL_NAMA+" text,"
            +" "+COL_JENIS+" integer,"
            +" "+COL_JUMLAH+" integer,"
            +" "+COL_KETERANGAN+" text)";
    public static final String SQL_DELETE = "drop table if exists "+TABLE_NAME;

}
