package com.example.pendaftaransiswa;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class dsw extends SQLiteOpenHelper {

    public static final String Nama_Database = "stu.db";
    final String namaTable = "data";

    public dsw(Context context){
        super(context, Nama_Database, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table data(namasiswa TEXT, asalsekolah TEXT, alamat TEXT, tempatlahir TEXT, tanggallahir TEXT, tanggalujian TEXT, jurusan TEXT)");
    }
    @Override
    public  void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean simpan(String namasiswa, String asalsekolah, String alamat, String tempatlahir, String tanggallahir, String tanggalujian, String jurusan) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues v = new ContentValues();
        v.put("namasiswa", namasiswa);
        v.put("asalsekolah", asalsekolah);
        v.put("alamat", alamat);
        v.put("tempatlahir", tempatlahir);
        v.put("tanggallahir", tanggallahir);
        v.put("tanggalujian", tanggalujian);
        v.put("jurusan", jurusan);
        long results;
        results = db.insert(namaTable,null, v);

        if(results==-1){
            return false;

        }
        else{
            return true;
        }
    }

    public Cursor lihat(){
        SQLiteDatabase var = this.getReadableDatabase();
        Cursor c = var.rawQuery("select * from " + namaTable,null);
        return  c;
    }


}


