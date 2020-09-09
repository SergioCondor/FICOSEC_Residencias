package com.example.vinos.Modelos;

public class Vino {
    String id;
    String nombre;
    String imagen;
    String likes;
    String detalles;

    public Vino(String id, String nombre, String imagen, String likes, String detalles) {
        this.id = id;
        this.nombre = nombre;
        this.imagen = imagen;
        this.likes = likes;
        this.detalles = detalles;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }


}
