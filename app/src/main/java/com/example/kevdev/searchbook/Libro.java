package com.example.kevdev.searchbook;

/**
 * Created by KevDev on 16/03/16.
 */
//Modelo del Libro
public class Libro {
    private String tituloLibro;
    private String AutorLibro;
    private String CategoriaLibro;
    private String AreaLibro;
    private float precioLibro;

    public Libro (String tituloLibro, String AutorLibro, String CategoriaLibro, String AreaLibro, float precioLibro){

        this.tituloLibro = tituloLibro;
        this.AutorLibro = AutorLibro;
        this.CategoriaLibro = CategoriaLibro;
        this.AreaLibro = AreaLibro;
        this.precioLibro = precioLibro;
    }

    public String getTituloLibro() { return tituloLibro; }

    public String getAutorLibro() { return AutorLibro; }

    public String getCategoriaLibro(){
        return CategoriaLibro;
    }

    public String getAreaLibro(){
        return AreaLibro;
    }

    public float getPrecioLibro() { return precioLibro; }

    public void setTituloLibro(String tituloLibro){
        this.tituloLibro = tituloLibro;
    }

    public void setAutorLibro(String autorLibro){
        this.AutorLibro = autorLibro;
    }

    public void setCategoriaLibro(String categoriaLibro){
        this.CategoriaLibro = categoriaLibro;
    }

    public void setAreaLibroTitulo(String areaLibro){
        this.AreaLibro = areaLibro;
    }

    public void setPrecioLibro(float precioLibro){
        this.precioLibro = precioLibro;
    }
}
