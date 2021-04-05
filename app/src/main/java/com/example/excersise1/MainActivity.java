package com.example.excersise1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txtuser;
    EditText txtpass;
    Button logbtn,dafbtn;


    boolean valid = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtuser = (EditText) findViewById(R.id.nim);

        txtpass = (EditText) findViewById(R.id.Password);

        logbtn = (Button) findViewById(R.id.logbtn);
        dafbtn = (Button) findViewById(R.id.dafbtn);

        logbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkField( txtuser);
                checkField( txtpass);
                if (valid) {
                    if (
                            txtuser.getText().toString().equals("20160140003")&&txtpass.getText().toString().equals("123"))
                    {
                        Toast.makeText(getApplicationContext(), "LOGIN BERHASIL", Toast.LENGTH_LONG).show();
                        Intent login = new Intent(MainActivity.this, Home.class);
                        startActivity(login);
                    }else Toast.makeText(MainActivity.this, "User atau Password Salah", Toast.LENGTH_SHORT).show();
                }
            }
        });

        dafbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), Daftar.class);
                startActivity(intent1);
            }
        });

    }
    private boolean checkField(EditText textField) {
        if(textField.getText().toString().isEmpty()){
            textField.setError("Harus di isi");
            valid = false;
        }else {
            valid = true;
        }

        return valid;
    }
}