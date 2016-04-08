package com.example.kevdev.searchbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PrincipalUser extends AppCompatActivity {

    Button btnLogOut, onAgregarLibro,onModifData, onDeleteUser,onSerchBook;
    private TextView Textv;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_user);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnLogOut = (Button)findViewById(R.id.btn_logout);
        onAgregarLibro = (Button) findViewById(R.id.btn_goToDelLibro);
        onModifData = (Button) findViewById(R.id.btn_toModifData);
        onDeleteUser = (Button) findViewById(R.id.btn_bajaUser);
        onSerchBook = (Button) findViewById(R.id.btn_searchBook);
        Textv = (TextView)findViewById(R.id.txtTV);
        Intent iin= getIntent();
        Bundle b = iin.getExtras();

        if(b!=null)
        {
            String j =(String) b.get("name");
            Textv.setText(j);
        }


    }
    public void onAgregarLibro(){
        toast.makeText(getApplicationContext(), "Aqui debería agregar un nuevo libro", Toast.LENGTH_LONG).show();
    }
    public void onModifData(){
        toast.makeText(getApplicationContext(), "Aqui deberia modificar los datos del usuario", Toast.LENGTH_LONG).show();
    }
    public void onDeleteUser(){
        toast.makeText(getApplicationContext(), "Aqui deberia eliminar el usuario", Toast.LENGTH_LONG).show();
    }
    public void onSerchBook(){
        toast.makeText(getApplicationContext(), "Aqui deberia buscar un libro", Toast.LENGTH_LONG).show();
    }
    public void LogOut(View view){
        this.finish();
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

}
