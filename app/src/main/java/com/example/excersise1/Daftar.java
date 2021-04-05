package com.example.excersise1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class Daftar extends AppCompatActivity {
    EditText edtNama, edtemail, edtpassword,edtrepassword;

    RadioButton laki,perempuan;

    Button btnSubmit,btngagal;

    boolean valid = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        edtemail = findViewById(R.id.edtemail);
        edtpassword = findViewById(R.id.password);
        edtrepassword = findViewById(R.id.repassword);
        edtNama = findViewById(R.id.edtNama_edit);


        laki = findViewById(R.id.rbLaki_edit);
        perempuan = findViewById(R.id.rbPerempuan_edit);

        btnSubmit = findViewById(R.id.btnsimpan);
        btngagal = findViewById(R.id.btnbatal);



        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkField( edtemail);
                checkField(  edtpassword);
                checkField(  edtrepassword);
                checkField(  edtNama);


                //chack
                if(!( laki.isChecked()||perempuan.isChecked())){
                    Toast.makeText(Daftar.this,"data harus di isi",Toast.LENGTH_SHORT).show();
                    return;
                }

                if (valid)
                {
                    edtNama.getText().toString().isEmpty();
                    edtemail.getText().toString().isEmpty();
                    edtpassword.getText().toString().isEmpty();
                    edtrepassword.getText().toString().isEmpty();

                }
                else
                {
                    if(edtpassword.getText().toString().equals(  edtrepassword.getText().toString()))
                    {
                        Toast.makeText(getApplicationContext(),"daftar berhasil",Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(i);
                    }
                    else {
                        Snackbar.make(v,"password dan repasword harus sama ",Snackbar.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private boolean checkField(EditText textField) {
        if(textField.getText().toString().isEmpty()){
            textField.setError("Harus di isi ");
            valid = false;
        }else {
            valid = true;
        }

        return valid;
    }
}