package com.example.kevdev.searchbook;

/**
 * Created by PREPA on 07/04/2016.
 */
public class UsuarioAdministrador extends Usuario {
    private static int contador = 1;
    private String Nombre;
    private String Apellido;
    private String Correo;
    private String password;


    public UsuarioAministrador(int ID, String NombreUser, String ApellidosUser,String email, String passwordUser){
        super(contador);
        this.Apellido = ApellidosUser;
        this.Correo = email;
        this.Nombre = NombreUser;
        this.password = passwordUser;
        restablecer();
    }

    public Usuarioregistrado(){
        super(contador);
        Nombre = "";
        Apellido = "";
        Correo = "";
        password = "";
        restablecer();
    }

    public String getNombre() { return Nombre; }

    public void setNombre(String nombre){
        this.Nombre = nombre;
    }

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

    private void restablecer() {
        if (contador == 99)
            contador = 1;
    }
}
