package com.example.kevdev.searchbook;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;

import java.util.List;

public class MenuEliminarFrmUser extends AppCompatActivity {
    ConexionDB conexionDB;
    Cursor cursor;
    SimpleCursorAdapter adapter;
    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_eliminarfrmuser);

        conexionDB = new ConexionDB(this);
        lista = (ListView) findViewById(R.id.listView);

        String[] from = new String[]{"NOMBRE","EMAIL"};
        int[] to = new int[]{android.R.id.text1,android.R.id.text2};

        cursor = conexionDB.cargarCursorUsers();
        adapter = new SimpleCursorAdapter(this, android.R.layout.two_line_list_item,cursor,from,to,0);
        lista.setAdapter(adapter);

    }
}
