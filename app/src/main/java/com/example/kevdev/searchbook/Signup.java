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

public class Signup extends AppCompatActivity {

    EditText editTextUserName,editTextPassword,editTextConfirmPassword, editTextEmail, editTextPhone, editTextLastName, editTextName;
    Button btnCreateAccount, cancel;

    LoginDataBaseAdapter loginDataBaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_signup);

        // get Instance  of Database Adapter
        loginDataBaseAdapter=new LoginDataBaseAdapter(this);
        loginDataBaseAdapter=loginDataBaseAdapter.open();

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
        String emailUser = editTextEmail.getText().toString();
        String name = editTextName.getText().toString();
        String lastName = editTextLastName.getText().toString();
        String phone = editTextPhone.getText().toString();
        String userName=editTextUserName.getText().toString();
        String password=editTextPassword.getText().toString();
        String confirmPassword=editTextConfirmPassword.getText().toString();

        // check if any of the fields are vaccant
        if(userName.equals("")||password.equals("")||confirmPassword.equals("")||emailUser.equals(""))
        {
            Toast.makeText(getApplicationContext(), "Completa los campos", Toast.LENGTH_LONG).show();
            return;
        }
        // check if both password matches
        if(!password.equals(confirmPassword))
        {
            Toast.makeText(getApplicationContext(), "La contraseñas no coinciden", Toast.LENGTH_LONG).show();
            return;
        }
        else
        {
            // Save the Data in Database
            loginDataBaseAdapter.insertEntry(userName,name,lastName,phone,password, emailUser);
            Toast.makeText(getApplicationContext(), "Cuenta Creada ", Toast.LENGTH_LONG).show();
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
    }
    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();

        loginDataBaseAdapter.close();
    }
    public void btn_toCancel(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

}
