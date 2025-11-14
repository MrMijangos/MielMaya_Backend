package com.mieleria.repository;

import com.mieleria.models.CancelledProduct;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CancelledProductRepository {

    public void create(CancelledProduct cancelled) {
        try {
            Connection conn = Database.getConnection();
            String sql = "INSERT INTO productos_cancelados (id_producto, razon) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, cancelled.getId_producto());
            stmt.setString(2, cancelled.getMotivo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<CancelledProduct> findAll() {
        List<CancelledProduct> list = new ArrayList<>();
        try {
            Connection conn = Database.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM productos_cancelados");
            while (rs.next()) {
                CancelledProduct p = new CancelledProduct();
                p.setId_cancelado(rs.getInt("id_cancelado"));
                p.setId_producto(rs.getInt("id_producto"));
                p.setMotivo(rs.getString("razon"));
                list.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public CancelledProduct findById(int id) {
        CancelledProduct p = null;
        try {
            Connection conn = Database.getConnection();
            String sql = "SELECT * FROM productos_cancelados WHERE id_cancelado=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                p = new CancelledProduct();
                p.setId_cancelado(rs.getInt("id_cancelado"));
                p.setId_producto(rs.getInt("id_producto"));
                p.setMotivo(rs.getString("razon"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    public void update(CancelledProduct cancelled) {
        try {
            Connection conn = Database.getConnection();
            String sql = "UPDATE productos_cancelados SET id_producto=?, razon=? WHERE id_cancelado=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, cancelled.getId_producto());
            stmt.setString(2, cancelled.getMotivo());
            stmt.setInt(3, cancelled.getId_cancelado());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            Connection conn = Database.getConnection();
            String sql = "DELETE FROM productos_cancelados WHERE id_cancelado=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
