package com.mieleria.models;

public class User {
    private int id_user;
    private String nombre;
    private String correo;
    private String contraseña;
    private String token; // 🔹 Nuevo campo

    public int getId_user() { return id_user; }
    public void setId_user(int id_user) { this.id_user = id_user; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getContraseña() { return contraseña; }
    public void setContraseña(String contraseña) { this.contraseña = contraseña; }

    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; } // 🔹 Getter y Setter
}
