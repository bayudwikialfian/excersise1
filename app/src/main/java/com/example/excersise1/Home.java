package com.example.excersise1;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.jar.Attributes;

public class Home extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    private ListView list;
    private ListViewAdapter adapter;
    String[] lisName;

    public static ArrayList<ClassName> classNameArrayList = new ArrayList<ClassName>();

    Bundle bundle =new Bundle();
    Intent intent;


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    lisName = new  String[]{"inayah","ilham","eris","Fikri","maul",
                           "intan","vina","gita","vian",
                            "lutfi"};

    list = findViewById(R.id.listKontak);
    for (int i =0; i<lisName.length; i++)
    {
        ClassName className = new ClassName(lisName[i]);
        classNameArrayList.add(className);
    }
    adapter = new ListViewAdapter(this);
    list.setAdapter(adapter);
    list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String name =classNameArrayList.get(position).getNama();
            bundle.putString("a",name.trim());

            PopupMenu pm = new PopupMenu(getApplicationContext(),view);
            pm.setOnMenuItemClickListener(Home.this);
            pm.inflate(R.menu.popup_menu);

            pm.show();
        }
    });
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId())
        {
            case   R.id.mnview:
                intent = new Intent(getApplicationContext(), ActivityLihatData.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case  R.id.mnedit:
                Toast.makeText(getApplicationContext(),"ini untuk edit kontak ",Toast.LENGTH_LONG).show();
                break;
        }
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}