package com.mieleria.models;

public class Comment {
    private int id_comentario;
    private String descripcion;
    private int id_user;
    private String calificacion; // "muy satisfecho", "satisfecho", "malo"

    public int getId_comentario() { return id_comentario; }
    public void setId_comentario(int id_comentario) { this.id_comentario = id_comentario; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public int getId_user() { return id_user; }
    public void setId_user(int id_user) { this.id_user = id_user; }

    public String getCalificacion() { return calificacion; }
    public void setCalificacion(String calificacion) { this.calificacion = calificacion; }
}
