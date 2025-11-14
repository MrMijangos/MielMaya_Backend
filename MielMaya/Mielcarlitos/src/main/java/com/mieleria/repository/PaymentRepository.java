package com.mieleria.repository;

import com.mieleria.models.PaymentMethod;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentRepository {

    public void create(PaymentMethod payment) {
        try {
            Connection conn = Database.getConnection();
            String sql = "INSERT INTO metodo_pago (id_user, nombre_tarjeta, num_tarjeta, fecha_expiracion, CVV) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, payment.getId_user());
            stmt.setString(2, payment.getNombre_tarjeta());
            stmt.setString(3, payment.getNum_tarjeta());
            stmt.setString(4, payment.getFecha_expiracion());
            stmt.setString(5, payment.getCVV());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<PaymentMethod> findAll() {
        List<PaymentMethod> list = new ArrayList<>();
        try {
            Connection conn = Database.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM metodo_pago");

            while (rs.next()) {
                PaymentMethod p = new PaymentMethod();
                p.setId_pago(rs.getInt("id_pago"));
                p.setId_user(rs.getInt("id_user"));
                p.setNombre_tarjeta(rs.getString("nombre_tarjeta"));
                p.setNum_tarjeta(rs.getString("num_tarjeta"));
                p.setFecha_expiracion(rs.getString("fecha_expiracion"));
                p.setCVV(rs.getString("CVV"));

                list.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public PaymentMethod findById(int id) {
        PaymentMethod p = null;
        try {
            Connection conn = Database.getConnection();
            String sql = "SELECT * FROM metodo_pago WHERE id_pago = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                p = new PaymentMethod();
                p.setId_pago(rs.getInt("id_pago"));
                p.setId_user(rs.getInt("id_user"));
                p.setNombre_tarjeta(rs.getString("nombre_tarjeta"));
                p.setNum_tarjeta(rs.getString("num_tarjeta"));
                p.setFecha_expiracion(rs.getString("fecha_expiracion"));
                p.setCVV(rs.getString("CVV"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    public void update(PaymentMethod payment) {
        try {
            Connection conn = Database.getConnection();
            String sql = "UPDATE metodo_pago SET id_user=?, nombre_tarjeta=?, num_tarjeta=?, fecha_expiracion=?, CVV=? WHERE id_pago=?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, payment.getId_user());
            stmt.setString(2, payment.getNombre_tarjeta());
            stmt.setString(3, payment.getNum_tarjeta());
            stmt.setString(4, payment.getFecha_expiracion());
            stmt.setString(5, payment.getCVV());
            stmt.setInt(6, payment.getId_pago());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            Connection conn = Database.getConnection();
            String sql = "DELETE FROM metodo_pago WHERE id_pago=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
