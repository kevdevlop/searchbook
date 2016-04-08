package com.example.kevdev.searchbook;

/**
 * Created by KevDev on 16/03/16.
 */
//Modelo de usuario
public class UsuarioRegistrado extends Usuario{
    private String Nombre;
    private String Apellido;
    private String Correo;
    private String password;


    public UsuarioRegistrado(int ID, String NombreUser, String ApellidosUser,String email, String passwordUser){
        super(ID);
        this.Apellido = ApellidosUser;
        this.Correo = email;
        this.Nombre = NombreUser;
        this.password = passwordUser;
    }

    public UsuarioRegistrado(){
        super();
        Nombre = "";
        Apellido = "";
        Correo = "";
        password = "";
    }
    public String getNombre() { return Nombre; }

    public void setNombre(String nombre){ this.Nombre = nombre; }

    public String getApellido() { return Apellido;}

    public void setApellido(String apellido){
        this.Apellido = apellido;
    }

    public void setCorreo(String email){
        this.Correo = email;
    }

    public String getCorreo(){
        return Correo;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String pass){
        this.password = pass;
    }

    public int getID() { return super.getID(); }

    public void setID(int ID){
        super(ID);
    }
}
