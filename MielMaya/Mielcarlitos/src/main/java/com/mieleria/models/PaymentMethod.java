package com.mieleria.models;

public class PaymentMethod {
    private int id_pago;
    private int id_user;
    private String nombre_tarjeta;
    private String num_tarjeta;
    private String fecha_expiracion;
    private String CVV;

    public int getId_pago() {
        return id_pago;
    }
    public void setId_pago(int id_pago) {
        this.id_pago = id_pago;
    }

    public int getId_user() {
        return id_user;
    }
    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getNombre_tarjeta() {
        return nombre_tarjeta;
    }
    public void setNombre_tarjeta(String nombre_tarjeta) {
        this.nombre_tarjeta = nombre_tarjeta;
    }

    public String getNum_tarjeta() {
        return num_tarjeta;
    }
    public void setNum_tarjeta(String num_tarjeta) {
        this.num_tarjeta = num_tarjeta;
    }

    public String getFecha_expiracion() {
        return fecha_expiracion;
    }
    public void setFecha_expiracion(String fecha_expiracion) {
        this.fecha_expiracion = fecha_expiracion;
    }

    public String getCVV() {
        return CVV;
    }
    public void setCVV(String CVV) {
        this.CVV = CVV;
    }
}
