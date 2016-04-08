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
            "( " +"ID"+" integer primary key autoincrement not null,"+ "NOMBRE TEXT, APELLIDOS TEXT, EMAIL TEXT,PASSWORD TEXT); ";

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

    //contenedor de valores a ocupar
    private ContentValues contentValues(String nombre,String apellidos,String password,String emailUser){
        ContentValues newValues = new ContentValues();

        newValues.put("EMAIL", emailUser);
        newValues.put("PASSWORD", password);
        newValues.put("NOMBRE", nombre);
        newValues.put("APELLIDOS", apellidos);

        return newValues;
    }

    public void agregarUsuario(String nombre,String apellidos,String password,String emailUser)
    {
        db.insert("LOGIN", null, contentValues(nombre, apellidos, password, emailUser));

    }

    public void deleteUser(String name){
        db.delete(TABLE_NAME, "NOMBRE" + "=?", new String[]{name});
    }

    public String getSingleEntry(String email)
    {
        Cursor cursor=db.query(TABLE_NAME, null, "EMAIL=?", new String[]{email}, null, null, null);
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

    public void modificarNombreApellido(String nombre,String apellidos,String password,String emailUser){
        db.update(TABLE_NAME, contentValues(nombre, apellidos, password, emailUser), "NOMBRE" + "=?", new String[]{nombre});
    }

    public Cursor cargarCursorUsers(){
        String[] columnas = {"ID","NOMBRE", "APELLIDOS","EMAIL", "PASSWORD"};
        return  db.query(TABLE_NAME,columnas,null,null,null,null,null);
    }



}


