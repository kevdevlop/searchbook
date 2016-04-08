package com.example.kevdev.searchbook;

/**
 * Created by KevDev on 16/03/16.
 */
//Modelo del Libro
public class Libro {
    private String Titulo;
    private String Autor;
    private String Categoria;
    private String Area;
    private float precio;
    private String Version;

    public Libro (String tituloLibro, String AutorLibro, String CategoriaLibro, String AreaLibro, float precioLibro, String version){

        this.Titulo = tituloLibro;
        this.Autor = AutorLibro;
        this.Categoria = CategoriaLibro;
        this.Area = AreaLibro;
        this.precio = precioLibro;
        this.Version = version;
    }

    public String getTitulo() { return Titulo; }

    public String getAutor() { return Autor; }

    public String getCategoria(){
        return Categoria;
    }

    public String getArea(){
        return Area;
    }

    public float getPrecio() { return precio; }

    public String getVersion() { return Version; }

    public void setTitulo(String tituloLibro){
        this.Titulo = tituloLibro;
    }

    public void setAutor(String autorLibro){
        this.Autor = autorLibro;
    }

    public void setCategoria(String categoriaLibro){
        this.Categoria = categoriaLibro;
    }

    public void setArea(String areaLibro){
        this.Area = areaLibro;
    }

    public void setPrecio(float precioLibro){
        this.precio = precioLibro;
    }

    public void setVersion(String version) { this.Version = version; }
}
