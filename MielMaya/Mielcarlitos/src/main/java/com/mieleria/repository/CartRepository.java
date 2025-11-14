package com.mieleria.repository;

import com.mieleria.models.CartItem;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartRepository {

    public void create(CartItem item) {
        try {
            Connection conn = Database.getConnection();
            String sql = "INSERT INTO carrito_compras (id_user, id_producto, cantidad) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, item.getId_user());
            stmt.setInt(2, item.getId_producto());
            stmt.setInt(3, item.getCantidad());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<CartItem> findAll() {
        List<CartItem> list = new ArrayList<>();
        try {
            Connection conn = Database.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM carrito_compras");
            while (rs.next()) {
                CartItem c = new CartItem();
                c.setId_carrito(rs.getInt("id_carrito"));
                c.setId_user(rs.getInt("id_user"));
                c.setId_producto(rs.getInt("id_producto"));
                c.setCantidad(rs.getInt("cantidad"));
                list.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public CartItem findById(int id) {
        CartItem item = null;
        try {
            Connection conn = Database.getConnection();
            String sql = "SELECT * FROM carrito_compras WHERE id_carrito = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                item = new CartItem();
                item.setId_carrito(rs.getInt("id_carrito"));
                item.setId_user(rs.getInt("id_user"));
                item.setId_producto(rs.getInt("id_producto"));
                item.setCantidad(rs.getInt("cantidad"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    public void update(CartItem item) {
        try {
            Connection conn = Database.getConnection();
            String sql = "UPDATE carrito_compras SET id_user = ?, id_producto = ?, cantidad = ? WHERE id_carrito = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, item.getId_user());
            stmt.setInt(2, item.getId_producto());
            stmt.setInt(3, item.getCantidad());
            stmt.setInt(4, item.getId_carrito());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            Connection conn = Database.getConnection();
            String sql = "DELETE FROM carrito_compras WHERE id_carrito = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
