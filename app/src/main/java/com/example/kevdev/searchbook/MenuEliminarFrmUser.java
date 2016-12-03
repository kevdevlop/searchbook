package com.example.kevdev.searchbook;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.preference.DialogPreference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MenuEliminarFrmUser extends AppCompatActivity {
    ConexionDB conexionDB;
    Cursor cursor;
    ListView lista;
    List<String> items = new ArrayList<>();
    TextView v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_eliminarfrmuser);

        conexionDB = new ConexionDB(this);
        conexionDB = conexionDB.open();
        lista = (ListView) findViewById(R.id.listView);
        v = (TextView) findViewById(R.id.txtLstItem);


        cursor = conexionDB.cargarCursorUsers();
        String nombre="";
        String email = "";
        if (cursor.moveToFirst()){

            do{

                email = cursor.getString(3);
                items.add(email);
            }while (cursor.moveToNext());
        }
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);

        lista.setAdapter(adapter);

        lista.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                Object obj = new Object();
                obj = lista.getItemAtPosition(position);
                v.setText("Elemento: " + obj);

            }

           }
        );

    }




}
