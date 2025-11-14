package com.mieleria.repository;

import com.mieleria.models.ShippingAddress;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShippingRepository {

    public void create(ShippingAddress address) {
        try {
            Connection conn = Database.getConnection();
            String sql = "INSERT INTO direccion_envio (id_user, calle, num, ext, codigo_postal, colonia, estado, municipio, celular) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, address.getId_user());
            stmt.setString(2, address.getCalle());
            stmt.setString(3, address.getNum());
            stmt.setString(4, address.getExt());
            stmt.setString(5, address.getCodigo_postal());
            stmt.setString(6, address.getColonia());
            stmt.setString(7, address.getEstado());
            stmt.setString(8, address.getMunicipio());
            stmt.setString(9, address.getCelular());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ShippingAddress> findAll() {
        List<ShippingAddress> list = new ArrayList<>();
        try {
            Connection conn = Database.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM direccion_envio");
            while (rs.next()) {
                ShippingAddress s = new ShippingAddress();
                s.setId_direccion(rs.getInt("id_direccion"));
                s.setId_user(rs.getInt("id_user"));
                s.setCalle(rs.getString("calle"));
                s.setNum(rs.getString("num"));
                s.setExt(rs.getString("ext"));
                s.setCodigo_postal(rs.getString("codigo_postal"));
                s.setColonia(rs.getString("colonia"));
                s.setEstado(rs.getString("estado"));
                s.setMunicipio(rs.getString("municipio"));
                s.setCelular(rs.getString("celular"));
                list.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ShippingAddress findById(int id) {
        ShippingAddress address = null;
        try {
            Connection conn = Database.getConnection();
            String sql = "SELECT * FROM direccion_envio WHERE id_direccion = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                address = new ShippingAddress();
                address.setId_direccion(rs.getInt("id_direccion"));
                address.setId_user(rs.getInt("id_user"));
                address.setCalle(rs.getString("calle"));
                address.setNum(rs.getString("num"));
                address.setExt(rs.getString("ext"));
                address.setCodigo_postal(rs.getString("codigo_postal"));
                address.setColonia(rs.getString("colonia"));
                address.setEstado(rs.getString("estado"));
                address.setMunicipio(rs.getString("municipio"));
                address.setCelular(rs.getString("celular"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return address;
    }

    public void update(ShippingAddress address) {
        try {
            Connection conn = Database.getConnection();
            String sql = "UPDATE direccion_envio SET id_user=?, calle=?, num=?, ext=?, codigo_postal=?, colonia=?, estado=?, municipio=?, celular=? WHERE id_direccion=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, address.getId_user());
            stmt.setString(2, address.getCalle());
            stmt.setString(3, address.getNum());
            stmt.setString(4, address.getExt());
            stmt.setString(5, address.getCodigo_postal());
            stmt.setString(6, address.getColonia());
            stmt.setString(7, address.getEstado());
            stmt.setString(8, address.getMunicipio());
            stmt.setString(9, address.getCelular());
            stmt.setInt(10, address.getId_direccion());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            Connection conn = Database.getConnection();
            String sql = "DELETE FROM direccion_envio WHERE id_direccion = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
