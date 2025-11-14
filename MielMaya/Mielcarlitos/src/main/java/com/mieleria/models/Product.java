package com.mieleria.models;

public class Product {
    private int id_producto;
    private String nombre;
    private double precio;
    private int cantidad;
    private String descripcion;
    private String imagen_base64;

    public int getId_producto() { return id_producto; }
    public void setId_producto(int id_producto) { this.id_producto = id_producto; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getImagen_base64() { return imagen_base64; }
    public void setImagen_base64(String imagen_base64) { this.imagen_base64 = imagen_base64; }
}
