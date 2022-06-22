package com.example.pendaftaransiswa.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DB extends SQLiteOpenHelper {

    public static final String Nama_Database = "student.db";
    public static final String Nama_Table = "siswa";
    public static final String col_1 = "id";
    public static final String col_2 = "akun_siswa";
    public static final String col_3 = "password";




    public DB(Context context) {
        super(context, Nama_Database, null, 1);


    }

    @Override
    public void onCreate(SQLiteDatabase DAs) {

        DAs.execSQL("create Table siswa (id Integer primary key,akunsiswa TEXT, Password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DAs, int oldVersion, int newVersion) {

        DAs.execSQL("drop Table if exists " + Nama_Table);
        onCreate(DAs);


    }

    public long insertData(String akun_siswa, String Password) {
        SQLiteDatabase DAs = this.getWritableDatabase();
        ContentValues v = new ContentValues();
        v.put("akun_siswa", akun_siswa);
        v.put("Password", Password);
        long results = DAs.insert("siswa", null, v);
        DAs.close();
        return results;

    }


    public Boolean ceknp(String akun_siswa, String Password) {

        String[] columns = {col_1};
        SQLiteDatabase Das = getReadableDatabase();
        String selection = col_2 + "=?" + " and " + col_3 + "=?";
        String[] selectionArgs = {akun_siswa, Password};
        Cursor cursor = Das.query(Nama_Table, columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        Das.close();

        if (count > 0)
            return true;
        else
            return false;

    }





}

