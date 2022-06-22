package com.example.pendaftaransiswa;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pendaftaransiswa.database.DB;

public class MainActivity extends AppCompatActivity {

    EditText acon, pass1;
    TextView rw;
    Button btlogin;
    DB dx;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        acon = findViewById(R.id.mail);
        pass1 = findViewById(R.id.passwords);
        btlogin=  findViewById(R.id.signin);
        rw= findViewById(R.id.daftar);
        dx = new DB(this);



        btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View z) {
                String email = acon.getText().toString().trim();
                String pass = pass1.getText().toString().trim();

                Boolean results = dx.ceknp(email, pass);

                if (results == true)
                {
                    Toast.makeText(MainActivity.this, "Login Berhasil ", Toast.LENGTH_SHORT).show();
                    Intent a =  new Intent(getApplicationContext(),MainMenu.class);
                    startActivity(a);



                }
                else
                {
                    Toast.makeText(MainActivity.this, "Login Gagal ", Toast.LENGTH_SHORT).show();

                }



            }
        });

        rw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(getApplicationContext(),Register.class);
                startActivity(b);
            }
        });

    }


}