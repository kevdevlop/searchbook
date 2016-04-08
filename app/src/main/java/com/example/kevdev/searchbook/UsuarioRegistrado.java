package com.example.kevdev.searchbook;

/**
 * Created by KevDev on 08/04/16.
 */
//TODO: subclase UsuarioRegistrado que se relaciona con la clase Usuario
public class UsuarioRegistrado extends Usuario {

    private String NombreUser;
    private String ApellidosUser;
    private String email;
    private String passwordUser;


    public UsuarioRegistrado( String NombreUser, String ApellidosUser,String email, String passwordUser, String userName){

        this.ApellidosUser = ApellidosUser;
        this.email = email;
        this.NombreUser = NombreUser;
        this.passwordUser = passwordUser;
    }

    public UsuarioRegistrado(){
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
