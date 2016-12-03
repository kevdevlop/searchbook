package com.example.kevdev.searchbook.model;

import com.example.kevdev.searchbook.model.Usuario;

/**
 * Created by KevDev on 08/04/16.
 */
//TODO: subclase UsuarioAdministrador que se relaciona con la clase Usuario
public class UsuarioAdministrador extends Usuario {

    private String NombreUser;
    private String ApellidosUser;
    private String email;
    private String passwordUser;


    public UsuarioAdministrador( String NombreUser, String ApellidosUser,String email, String passwordUser, String userName){
        this.ApellidosUser = ApellidosUser;
        this.email = email;
        this.NombreUser = NombreUser;
        this.passwordUser = passwordUser;
    }

    public UsuarioAdministrador(){
        NombreUser = "";
        ApellidosUser = "";
        email = "";
        passwordUser = "";
    }
    public String getNombreUser() {

        return NombreUser;
    }
    public void setNombreUser(String nombre){
        this.NombreUser = nombre;
    }

    public String getApellidosUser() { return ApellidosUser;}

    public void setApellidoUser(String apellido){
        this.ApellidosUser = apellido;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public String getPasswordUser(){
        return passwordUser;
    }

    public void setPasswordUser(String pass){
        this.passwordUser = pass;
    }






}
