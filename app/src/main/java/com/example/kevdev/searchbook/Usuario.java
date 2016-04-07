package com.example.kevdev.searchbook;

/**
 * Created by KevDev on 16/03/16.
 */
//Modelo de usuario
public class Usuario {
    private int ID;
    private String NombreUser;
    private String ApellidosUser;
    private String correoUser;
    private String passwordUser;
    int prskkao;

    public Usuario(int ID, String ApellidosUser, String NombreUser, String correoUser, String passwordUser){
        this.ID =  ID;
        this.ApellidosUser = ApellidosUser;
        this.NombreUser = NombreUser;
        this.correoUser = correoUser;
        this.passwordUser = passwordUser;
    }

    public String getNombreUser() {

        return NombreUser;
    }

    public String getApellidosUser() {

        return ApellidosUser;
    }

    public String getCorreoUser(){
        return correoUser;
    }

    public String getPasswordUser(){
        return passwordUser;
    }

    public int getID() {

        return ID;
    }

}
