package com.cidead.pmdm.listacomics;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Comic implements Parcelable {

    private String titulo;
    private int imagen; // Ruta o URL de la imagen
    private TipoComic tipo;

    protected Comic() {
    }

    protected Comic(Parcel in) {
        titulo = in.readString();
        imagen = in.readInt();
    }

    public static final Creator<Comic> CREATOR = new Creator<Comic>() {
        @Override
        public Comic createFromParcel(Parcel in) {
            return new Comic(in);
        }

        @Override
        public Comic[] newArray(int size) {
            return new Comic[size];
        }
    };

    /**
     * Describe the kinds of special objects contained in this Parcelable
     * instance's marshaled representation. For example, if the object will
     * include a file descriptor in the output of {@link #writeToParcel(Parcel, int)},
     * the return value of this method must include the
     * {@link #CONTENTS_FILE_DESCRIPTOR} bit.
     *
     * @return a bitmask indicating the set of special object types marshaled
     * by this Parcelable object instance.
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Flatten this object in to a Parcel.
     *
     * @param dest  The Parcel in which the object should be written.
     * @param flags Additional flags about how the object should be written.
     *              May be 0 or {@link #PARCELABLE_WRITE_RETURN_VALUE}.
     */
    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(titulo);
        dest.writeInt(imagen);
    }

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
