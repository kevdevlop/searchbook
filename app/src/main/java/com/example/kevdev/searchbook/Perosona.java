package com.example.kevdev.searchbook;

/**
 * Created by PREPA on 07/04/2016.
 */
public class Usuario {
    private static int contador = 100;
    private int ID;

    public Usuario(int ID){
        this.ID = ID;
    }

    public Usuario(){ ID = contador; }

    public int getID() {
        return ID;
    }

    public void setID(int ID){ this.ID = ID; }

}
