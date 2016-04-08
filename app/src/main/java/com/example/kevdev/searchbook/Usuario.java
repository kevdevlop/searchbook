package com.example.kevdev.searchbook;

/**
 * Created by KevDev on 16/03/16.
 */
//Modelo de usuario
public class Usuario {
    private int ID;
    private String NombreUser;
    private String ApellidosUser;
    private String email;
    private String phone;
    private String passwordUser;


    public Usuario(int ID, String NombreUser, String ApellidosUser,String email, String phone, String passwordUser){
        this.ID =  ID;
        this.ApellidosUser = ApellidosUser;
        this.email = email;
        this.phone = phone;
        this.NombreUser = NombreUser;
        this.passwordUser = passwordUser;
    }

    public Usuario(){
        NombreUser = "";
        ApellidosUser = "";
        email = "";
        phone = "";
        passwordUser = "";
    }
    public String getNombreUser() { return NombreUser; }

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

    public int getID() { return ID; }

    public void setID(int ID){
        this.ID = ID;
    }

    public String getPhone(){return phone;}

    public void setPhone(String phone){this.phone = phone;}
}
