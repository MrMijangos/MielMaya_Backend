package com.mieleria.models;

public class ShippingAddress {
    private int id_direccion;
    private int id_user;
    private String calle;
    private String num;
    private String ext;
    private String codigo_postal;
    private String colonia;
    private String estado;
    private String municipio;
    private String celular;

    public int getId_direccion() { return id_direccion; }
    public void setId_direccion(int id_direccion) { this.id_direccion = id_direccion; }

    public int getId_user() { return id_user; }
    public void setId_user(int id_user) { this.id_user = id_user; }

    public String getCalle() { return calle; }
    public void setCalle(String calle) { this.calle = calle; }

    public String getNum() { return num; }
    public void setNum(String num) { this.num = num; }

    public String getExt() { return ext; }
    public void setExt(String ext) { this.ext = ext; }

    public String getCodigo_postal() { return codigo_postal; }
    public void setCodigo_postal(String codigo_postal) { this.codigo_postal = codigo_postal; }

    public String getColonia() { return colonia; }
    public void setColonia(String colonia) { this.colonia = colonia; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getMunicipio() { return municipio; }
    public void setMunicipio(String municipio) { this.municipio = municipio; }

    public String getCelular() { return celular; }
    public void setCelular(String celular) { this.celular = celular; }
}
