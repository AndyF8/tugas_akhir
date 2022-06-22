package com.example.pendaftaransiswa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pendaftaransiswa.database.DB;

public class Register extends AppCompatActivity {

    Button regis;

    EditText  mail, passs, repass;

    DB ds;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        mail = findViewById(R.id.mail0);
        passs = findViewById(R.id.Pass0);
        repass = findViewById(R.id.repass0);
        regis = findViewById(R.id.tregister);
        ds = new DB(this);

        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String akun = mail.getText().toString().trim();
                String pass = passs.getText().toString().trim();
                String pass00 = repass.getText().toString().trim();

                if(pass.equals(pass00)){

                    long erw = ds.insertData(akun,pass);
                    if (erw>0) {
                        Toast.makeText(Register.this, "Register Berhasil", Toast.LENGTH_SHORT).show();
                        Intent x =  new Intent(Register.this, MainActivity.class);
                        startActivity(x);
                    }
                    else {
                        Toast.makeText(Register.this, "Register Gagal", Toast.LENGTH_SHORT).show();
                    }

                }

                else{
                    Toast.makeText(Register.this, "Password Tidak Sesuai", Toast.LENGTH_SHORT).show();

                }





            }
        });

    }





}
