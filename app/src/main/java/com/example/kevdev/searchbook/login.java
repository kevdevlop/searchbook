package com.example.kevdev.searchbook;

import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    EditText editTextUserName, editTextPassword;
    Button btnLogIn, btnToSignUp;
    ConexionDB conexionDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUserName=(EditText)findViewById(R.id.txtUsernameLogin);
        editTextPassword=(EditText)findViewById(R.id.editTextPassLogin);
        btnLogIn=(Button)findViewById(R.id.buttonLogin);
        btnToSignUp = (Button)findViewById(R.id.btn_toSignUp);

        conexionDB = new ConexionDB(this);
        conexionDB = conexionDB.open();

    }

    public void toSignUp(View v){

    }
    public void btnLogin(View v){

        String correo=editTextUserName.getText().toString();
        String password=editTextPassword.getText().toString();

        // fetch the Password form database for respective user name
        String storedPassword=conexionDB.getSingleEntry(password);
        String email_admin =conexionDB.getSingleEntry(correo);

        if (correo.equals(email_admin) && password.equals(storedPassword)){

            Toast.makeText(this, "Felicidades: Ingreso Exitoso", Toast.LENGTH_LONG).show();
            Intent i = new Intent(this, PrincipalAdmin.class);
            i.putExtra("name", correo);
            startActivity(i);

        }else
            // check if the Stored password and  email matches with  Password and correo entered by user
            if (password.equals(storedPassword) && correo.equals(email_admin)) {
                Toast.makeText(this, "Felicidades: Ingreso Exitoso", Toast.LENGTH_LONG).show();
                Intent i = new Intent(this, PrincipalUser.class);
                i.putExtra("name", correo);
                startActivity(i);
            // check if the stored password matches with the password entered
            } else if (!password.equals(storedPassword)){
                Toast.makeText(this, "Contraseña Incorrecta", Toast.LENGTH_LONG).show();
            // returns correo not matches whit the email stored
            } else Toast.makeText(this, "Correo Incorrecto", Toast.LENGTH_LONG).show();


    }


}
