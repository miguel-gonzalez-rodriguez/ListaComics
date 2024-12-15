package com.cidead.pmdm.listacomics;

public class Comic {

    private String titulo;
    private int imagen; // Ruta o URL de la imagen
    private TipoComic tipo;

    // Enum para representar los tipos de cómics
    public enum TipoComic {
        AMERICANO,
        EUROPEO,
        MANGA,
        INFANTIL
    }

    // Constructor
    public Comic(String titulo, int imagen, TipoComic tipo) {
        this.titulo = titulo;
        this.imagen = imagen;
        this.tipo = tipo;
    }

    // Getters y Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public TipoComic getTipo() {
        return tipo;
    }

    public void setTipo(TipoComic tipo) {
        this.tipo = tipo;
    }

    // Método toString para mostrar la información del cómic
    @Override
    public String toString() {
        return "Comic [Título: " + titulo + ", Imagen: " + imagen + ", Tipo: " + tipo + "]";
    }
}
