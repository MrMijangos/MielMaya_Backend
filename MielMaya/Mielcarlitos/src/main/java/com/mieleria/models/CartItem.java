package com.mieleria.models;

public class CartItem {
    private int id_carrito;
    private int id_user;
    private int id_producto;
    private int cantidad;

    public int getId_carrito() { return id_carrito; }
    public void setId_carrito(int id_carrito) { this.id_carrito = id_carrito; }

    public int getId_user() { return id_user; }
    public void setId_user(int id_user) { this.id_user = id_user; }

    public int getId_producto() { return id_producto; }
    public void setId_producto(int id_producto) { this.id_producto = id_producto; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
}
