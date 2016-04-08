package com.example.kevdev.searchbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PrincipalUser extends AppCompatActivity implements View.OnClickListener {

    Button buttonLogOut, buttonDelUser, buttonSearchBook , buttonModifData, buttonAddBook;
    private TextView Textv;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_user);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        buttonLogOut = (Button) findViewById(R.id.btn_logout);
        buttonAddBook = (Button) findViewById(R.id.btn_goToAddLibro);
        buttonDelUser = (Button) findViewById(R.id.btn_bajaUser);
        buttonModifData = (Button) findViewById(R.id.btn_toModifData);
        buttonSearchBook = (Button) findViewById(R.id.btn_searchBook);

        buttonAddBook.setOnClickListener(this);
        buttonDelUser.setOnClickListener(this);
        buttonModifData.setOnClickListener(this);
        buttonLogOut.setOnClickListener(this);
        buttonSearchBook.setOnClickListener(this);

        Textv = (TextView)findViewById(R.id.txtTV);
        Intent iin= getIntent();
        Bundle b = iin.getExtras();

        if(b!=null)
        {
            String j =(String) b.get("name");
            Textv.setText(j);
        }


    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_bajaUser){
            Toast.makeText(getApplicationContext(), "Aqui debería darse de baja", Toast.LENGTH_LONG).show();

        }else if (v.getId() == R.id.btn_goToAddLibro){

            Toast.makeText(getApplicationContext(), "Aqui debería agregar un nuevo libro", Toast.LENGTH_LONG).show();

        }else if (v.getId() == R.id.btn_toModifData){

            Toast.makeText(getApplicationContext(), "Aqui deberia modificar los datos del usuario", Toast.LENGTH_LONG).show();

        }else if (v.getId() == R.id.btn_logout){
            this.finish();
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);

        }else if (v.getId() == R.id.btn_searchBook){
            Toast.makeText(getApplicationContext(), "Aqui deberia realizar la busqueda de un libro", Toast.LENGTH_LONG).show();
        }
    }

}
