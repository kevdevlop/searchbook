package com.example.kevdev.searchbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kevdev.searchbook.model.UsuarioRegistrado;

//TODO: clase para registrar a un usuario, ya que en andriod se crea una clase por cada vista
// En el documento no aparece esta clase ya que en android se maneja diferente
public class Signup extends AppCompatActivity {

    EditText editTextPassword,editTextConfirmPassword, editTextEmail, editTextLastName, editTextName;
    Button btnCreateAccount, cancel;
    UsuarioRegistrado user;

    ConexionDB conexionDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_signup);

        // obteniendo instancias de Database Adapter
        conexionDB=new ConexionDB(this);
        conexionDB=conexionDB.open();

        // obteniendo referencias de las Views
        editTextEmail=(EditText)findViewById(R.id.EditTxtEmailUser);

        editTextPassword=(EditText)findViewById(R.id.editTextPassword);
        editTextName = (EditText) findViewById(R.id.editTxtName);
        editTextLastName = (EditText) findViewById(R.id.EditTxtLastName);
        editTextConfirmPassword=(EditText)findViewById(R.id.editTextPasswordConfirm);

        btnCreateAccount=(Button)findViewById(R.id.btn_toSignUp);
        cancel = (Button)findViewById(R.id.btn_toCancel);

    }
    public  void toSignUp(View v){
        user = new UsuarioRegistrado();
        user.setNombreUser(editTextName.getText().toString());
        user.setEmail(editTextEmail.getText().toString());
        user.setApellidoUser(editTextLastName.getText().toString());
        user.setPasswordUser(editTextPassword.getText().toString());


        String confirmPassword=editTextConfirmPassword.getText().toString();

        // verificar si no hay campos vacios
        if(user.getNombreUser().equals("")||user.getApellidosUser().equals("")||confirmPassword.equals("")||user.getEmail().equals(""))
        {
            Toast.makeText(getApplicationContext(), "Completa los campos", Toast.LENGTH_LONG).show();
            return;
        }
        // verificar si las passwords coinciden
        if(!user.getPasswordUser().equals(confirmPassword))
        {
            Toast.makeText(getApplicationContext(), "La contraseñas no coinciden", Toast.LENGTH_LONG).show();
            return;
        }
        if(user.getPasswordUser().length() > 8 && user.getPasswordUser().length() < 16){
            if (!user.getPasswordUser().equals(confirmPassword)) {
                Toast.makeText(getApplicationContext(), "Las contraseñas no coinciden", Toast.LENGTH_LONG).show();
                return;
            }
            Toast.makeText(getApplicationContext(), "Minimo 8 caracteres y maximo 16", Toast.LENGTH_LONG).show();
            return;
        }
        for(int i = 0 ; i < user.getNombreUser().length() ; i++)
            if(!letra(user.getNombreUser().charAt(i))){
                Toast.makeText(getApplicationContext(), "Introducir solamente letras", Toast.LENGTH_LONG).show();
                return;
            }

        if (user.getPasswordUser().length() < 8 ){
            Toast.makeText(getApplicationContext(), "Por lo menos deben ser 8 digitos en el password", Toast.LENGTH_LONG).show();
            return;
        }

        else
        {
            // guardar en DB
            conexionDB.agregarUsuario(user.getNombreUser(),user.getApellidosUser()
                    ,user.getPasswordUser(), user.getEmail());
            Toast.makeText(getApplicationContext(), "Cuenta Creada ", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();

        conexionDB.close();
    }
    public void btn_toCancel(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public boolean letra(int a) {
        if ('a' >= 'a' && 'a' <= 'z') {
            return true;
        } else if ('a' >= 'A' && 'a' <= 'Z') {
            return true;
        } else {
            return false;
        }
    }

}
