package com.example.kevdev.searchbook;

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

//TODO: clase para registrar a un usuario, ya que en andriod se crea una clase por cada vista
// En el documento no aparece esta clase ya que en android se maneja diferente
public class Signup extends AppCompatActivity {

    EditText editTextUserName,editTextPassword,editTextConfirmPassword, editTextEmail, editTextPhone, editTextLastName, editTextName;
    Button btnCreateAccount, cancel;
    Usuario user;

    ConexionDB conexionDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_signup);

        // get Instance  of Database Adapter
        conexionDB=new ConexionDB(this);
        conexionDB=conexionDB.open();

        // Get Refferences of Views
        editTextEmail=(EditText)findViewById(R.id.EditTxtEmailUser);
        editTextUserName=(EditText)findViewById(R.id.EditTxtUsernameSignUp);
        editTextPassword=(EditText)findViewById(R.id.editTextPassword);
        editTextName = (EditText) findViewById(R.id.editTxtName);
        editTextPhone = (EditText) findViewById(R.id.editTxtPhone);
        editTextLastName = (EditText) findViewById(R.id.EditTxtLastName);
        editTextConfirmPassword=(EditText)findViewById(R.id.editTextPasswordConfirm);

        btnCreateAccount=(Button)findViewById(R.id.btn_toSignUp);
        cancel = (Button)findViewById(R.id.btn_toCancel);

    }
    public  void toSignUp(View v){
        user = new Usuario();
        user.setNombreUser(editTextName.getText().toString());
        user.setUserName(editTextUserName.getText().toString());
        user.setEmail(editTextEmail.getText().toString());
        user.setApellidoUser(editTextLastName.getText().toString());
        user.setPasswordUser(editTextPassword.getText().toString());
        user.setPhone(editTextPhone.getText().toString());

        String confirmPassword=editTextConfirmPassword.getText().toString();

        // check if any of the fields are vaccant
        if(user.getNombreUser().equals("")||user.getApellidosUser().equals("")||confirmPassword.equals("")||user.getEmail().equals("")
                || user.getPhone().equals("") || user.getUserName().equals(""))
        {
            Toast.makeText(getApplicationContext(), "Completa los campos", Toast.LENGTH_LONG).show();
            return;
        }
        // check if both password matches
        if(!user.getPasswordUser().equals(confirmPassword))
        {
            Toast.makeText(getApplicationContext(), "La contraseñas no coinciden", Toast.LENGTH_LONG).show();
            return;
        }
        else
        {
            // Save the Data in Database
            conexionDB.agregarUsuario(user.getUserName(),user.getNombreUser(),user.getApellidosUser(),user.getPhone()
                    ,user.getPasswordUser(), user.getEmail());
            Toast.makeText(getApplicationContext(), "Cuenta Creada ", Toast.LENGTH_LONG).show();
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
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

}
