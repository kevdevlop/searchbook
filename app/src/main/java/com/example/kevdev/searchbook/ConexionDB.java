package com.example.kevdev.searchbook;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
/**
 * Created by KevDev on 07/04/16.
 */

// TODO: esta clase es para la conexion a la base de datos y el CRUD (insertar, eliminar y actualizar)

public class ConexionDB {

    static final String DATABASE_NAME = "Searchbook.db";
    static final int DATABASE_VERSION = 1;
    static final String TABLE_NAME = "LOGIN";
    public static final int NAME_COLUMN = 1;


    static final String DATABASE_CREATE = "create table "+ TABLE_NAME +
            "( " +"ID"+" integer primary key autoincrement not null,"+ "USERNAME  TEXT,NOMBRE TEXT, APELLIDOS TEXT, EMAIL TEXT,PHONE TEXT,PASSWORD TEXT); ";

    public SQLiteDatabase db;

    private final Context context;

    private DataBaseHelper dbHelper;
    public  ConexionDB(Context _context)
    {
        context = _context;
        dbHelper = new DataBaseHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public  ConexionDB open() throws SQLException
    {
        db = dbHelper.getWritableDatabase();
        return this;
    }
    public void close()
    {
        db.close();
    }

    public  SQLiteDatabase getDatabaseInstance()
    {
        return db;
    }

    public void agregarUsuario(String userName,String nombre,String apellidos,String phone,String password,String emailUser)
    {
        ContentValues newValues = new ContentValues();

        newValues.put("USERNAME", userName);
        newValues.put("EMAIL", emailUser);
        newValues.put("PASSWORD", password);
        newValues.put("NOMBRE", nombre);
        newValues.put("APELLIDOS", apellidos);
        newValues.put("PHONE", phone);



        db.insert("LOGIN", null, newValues);

    }

    public String getSingleEntry(String userName)
    {
        Cursor cursor=db.query("LOGIN", null, "USERNAME=?", new String[]{userName}, null, null, null);
        if(cursor.getCount()<1)
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String password= cursor.getString(cursor.getColumnIndex("PASSWORD"));
        cursor.close();
        return password;
    }



}


