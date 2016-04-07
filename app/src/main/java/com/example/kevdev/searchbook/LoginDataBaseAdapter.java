package com.example.kevdev.searchbook;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by KevDev on 05/04/16.
 */
public class LoginDataBaseAdapter {
    static final String DATABASE_NAME = "Searchbook.db";
    static final int DATABASE_VERSION = 1;
    static final String TABLE_NAME = "LOGIN";
    public static final int NAME_COLUMN = 1;
    // TODO: Create public field for each column in your table.
    // SQL Statement to create a new database.
    static final String DATABASE_CREATE = "create table "+ TABLE_NAME +
            "( " +"ID"+" integer primary key autoincrement not null,"+ "USERNAME  TEXT,NOMBRE TEXT, APELLIDOS TEXT, EMAIL TEXT,PHONE TEXT,PASSWORD TEXT); ";
    // Variable to hold the database instance
    public SQLiteDatabase db;
    // Context of the application using the database.
    private final Context context;
    // Database open/upgrade helper
    private DataBaseHelper dbHelper;
    public  LoginDataBaseAdapter(Context _context)
    {
        context = _context;
        dbHelper = new DataBaseHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public  LoginDataBaseAdapter open() throws SQLException
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

    public void insertEntry(String userName,String nombre,String apellidos,String phone,String password,String emailUser)
    {
        ContentValues newValues = new ContentValues();
        // Assign values for each row.
        newValues.put("USERNAME", userName);
        newValues.put("EMAIL", emailUser);
        newValues.put("PASSWORD", password);
        newValues.put("NOMBRE", nombre);
        newValues.put("APELLIDOS", apellidos);
        newValues.put("PHONE", phone);


        // Insert the row into your table
        db.insert("LOGIN", null, newValues);
        ///Toast.makeText(context, "Reminder Is Successfully Saved", Toast.LENGTH_LONG).show();
    }

    public String getSinlgeEntry(String userName)
    {
        Cursor cursor=db.query("LOGIN", null, "USERNAME=?", new String[]{userName}, null, null, null);
        if(cursor.getCount()<1) // UserName Not Exist
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String password= cursor.getString(cursor.getColumnIndex("PASSWORD"));
        cursor.close();
        return password;
    }

    public void addNewTratament(String newTrata, String userName) {
        ContentValues newValues = new ContentValues();
        // Assign values for each row.
        newValues.put("TRATAMIENTO", newTrata);

        String where = "USERNAME=?";

        db.update("LOGIN", newValues, where, new String[]{userName});
        //Toast.makeText(context, "Reminder Is Successfully Saved", Toast.LENGTH_LONG).show();
    }
}
