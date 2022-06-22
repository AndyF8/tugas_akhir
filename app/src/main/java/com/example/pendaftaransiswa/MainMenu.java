package com.example.pendaftaransiswa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainMenu extends AppCompatActivity {

    Button isi;
    Button lihat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainmenu);

        isi=  findViewById(R.id.isidata);
        lihat = findViewById(R.id.button2);

        isi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View c) {

                Intent b = new Intent(getApplicationContext(), Isidata.class);
                startActivity(b);
            }


        });

        lihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View c) {

                Intent f = new Intent(getApplicationContext(), lihatdata.class);
                startActivity(f);
            }
        });
    }
}
