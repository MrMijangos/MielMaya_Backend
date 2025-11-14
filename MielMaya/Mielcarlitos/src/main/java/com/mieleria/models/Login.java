package com.mieleria.models;

public class Login {
    private String correo;
    private String contraseña;
    private String token;

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getContraseña() { return contraseña; }
    public void setContraseña(String contraseña) { this.contraseña = contraseña; }

    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }
}
