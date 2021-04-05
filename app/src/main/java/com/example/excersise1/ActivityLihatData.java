package com.example.excersise1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class ActivityLihatData extends AppCompatActivity {

    TextView tvnama, tvemail;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data);

        tvnama = findViewById(R.id.tvnama);
        tvemail = findViewById(R.id.tvemail);


        Bundle bundle = getIntent().getExtras();
        String nama = bundle.getString("a");

        switch (nama)
        {
            case "inayah":
                tvnama.setText("inayah M");
                tvemail.setText("inayah@gmail.com");
                break;
            case "ilham":
                tvnama.setText("ilham R");
                tvemail.setText("ilham@gmail.com");
                break;
            case "eris":
                tvnama.setText("eris J");
                tvemail.setText("eris@gmail.com");
                break;
            case "fikri":
                tvnama.setText("fikri");
                tvemail.setText("rikri@gmail.com");
                break;
            case "maul":
                tvnama.setText("maul M");
                tvemail.setText("maul@gmail.com");
                break;
            case "intan":
                tvnama.setText("intan M");
                tvemail.setText("intan@gmail.com");
                break;
            case "vina":
                tvnama.setText("vina Y");
                tvemail.setText("vina@gmail.com");
                break;
            case "gita":
                tvnama.setText("gita J");
                tvemail.setText("gita@gmail.com");
                break;
            case "lutfi":
                tvnama.setText("lutfi M");
                tvemail.setText("lutfi@gmail.com");
                break;
            case "vian":
                tvnama.setText("vian M");
                tvemail.setText("vian@gmail.com");
                break;
        }

    }
}