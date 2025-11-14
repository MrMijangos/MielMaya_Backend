package com.mieleria.models;

public class CancelledProduct {
    private int id_cancelado;
    private int id_producto;
    private int id_user;
    private String motivo;

    public int getId_cancelado() { return id_cancelado; }
    public void setId_cancelado(int id_cancelado) { this.id_cancelado = id_cancelado; }

    public int getId_producto() { return id_producto; }
    public void setId_producto(int id_producto) { this.id_producto = id_producto; }

    public int getId_user() { return id_user; }
    public void setId_user(int id_user) { this.id_user = id_user; }

    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }
}
