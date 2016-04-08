package com.example.kevdev.searchbook;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;
import java.util.List;

public class MenuEliminarFrmUser extends AppCompatActivity {
    ConexionDB conexionDB;
    Cursor cursor;
    ListView lista;
    List<String> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_eliminarfrmuser);

        conexionDB = new ConexionDB(this);
        lista = (ListView) findViewById(R.id.listView);



        cursor = conexionDB.cargarCursorUsers();
        String nombre="";
        String email = "";
        if (cursor.moveToFirst()){

            do{
                nombre = cursor.getString(1);
                email = cursor.getString(3);
                items.add(nombre+"---"+email);
            }while (cursor.moveToNext());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);

        lista.setAdapter(adapter);

    }
}
