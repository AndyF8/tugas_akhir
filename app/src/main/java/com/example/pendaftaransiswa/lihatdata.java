package com.example.pendaftaransiswa;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class lihatdata extends AppCompatActivity {

    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lihatdata);

        dsw ds = new dsw(this);

        TextView nama = findViewById(R.id.namas);


        Cursor o = ds.lihat();
        StringBuilder s = new StringBuilder();

        while (o.moveToNext()) {
            s.append("Nama Siswa : "+o.getString(0)
                    +"\nTanggal Ujian :" +o.getString(1)+"\nJurusan :"+o.getString(1));
        }

        nama.setText(s);

    }

}
