package com.example.kevdev.searchbook;

/**
 * Created by KevDev on 16/03/16.
 */
//Modelo de usuario
//TODO: Super clase Usuario

public class Usuario {
    private int ID;


    public Usuario(int ID){
        this.ID =  ID;

    }

    public Usuario(){
        ID = 0;
    }

    public int getID() { return ID; }
    public void setID(int ID){
        this.ID = ID;
    }





}
