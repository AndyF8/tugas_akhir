package com.example.pendaftaransiswa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pendaftaransiswa.database.DB;

public class Isidata extends AppCompatActivity {

    dsw dw;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.isidata);

            dw = new dsw(this);

            EditText namasw, asalsekolah, alamat, tlahir, tglahir, tujian, jurusan;
            Button simpan;

            namasw = findViewById(R.id.siswa0);
            asalsekolah= findViewById(R.id.assekolah0);
            alamat =findViewById(R.id.alamat0);
            tlahir = findViewById(R.id.tlahir0);
            tglahir = findViewById(R.id.tglh0);
            tujian = findViewById(R.id.jurusan0);
            jurusan = findViewById(R.id.tujian0);
            simpan = findViewById(R.id.simpan);

            simpan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean results = dw.simpan(namasw.getText().toString(),asalsekolah.getText().toString(),alamat.getText().toString(),tlahir.getText().toString(),tglahir.getText().toString(),
                            tujian.getText().toString(),jurusan.getText().toString());
                    if(results==true){
                        Toast.makeText(getApplicationContext(), "Berhasil disimpan", Toast.LENGTH_SHORT).show();
                        Intent x =  new Intent(Isidata.this, lihatdata.class);
                        startActivity(x);
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "gagal tersimpan", Toast.LENGTH_SHORT).show();
                    }
                }
            });




        }
}
