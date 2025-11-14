package com.mieleria.repository;

import com.mieleria.models.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    public void create(Product product) {
        try {
            Connection conn = Database.getConnection();
            String sql = "INSERT INTO producto (nombre, precio, cantidad, descripcion, imagen_url) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, product.getNombre());
            stmt.setDouble(2, product.getPrecio());
            stmt.setInt(3, product.getCantidad());
            stmt.setString(4, product.getDescripcion());
            stmt.setString(5, product.getImagen_base64());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Product> findAll() {
        List<Product> list = new ArrayList<>();
        try {
            Connection conn = Database.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM producto");
            while (rs.next()) {
                Product p = new Product();
                p.setId_producto(rs.getInt("id_producto"));
                p.setNombre(rs.getString("Nombre"));
                p.setPrecio(rs.getDouble("Precio"));
                p.setCantidad(rs.getInt("Cantidad"));
                p.setDescripcion(rs.getString("Descripción"));
                p.setImagen_base64(rs.getString("Imagen"));
                list.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Product findById(int id) {
        Product product = null;
        try {
            Connection conn = Database.getConnection();
            String sql = "SELECT * FROM producto WHERE id_producto = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                product = new Product();
                product.setId_producto(rs.getInt("id_producto"));
                product.setNombre(rs.getString("Nombre"));
                product.setPrecio(rs.getDouble("Precio"));
                product.setCantidad(rs.getInt("Cantidad"));
                product.setDescripcion(rs.getString("Descripción"));
                product.setImagen_base64(rs.getString("Imagen"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    public void update(Product product) {
        try {
            Connection conn = Database.getConnection();
            String sql = "UPDATE producto SET Nombre=?, Precio=?, Cantidad=?, Descripción=?, Imagen=? WHERE id_producto=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, product.getNombre());
            stmt.setDouble(2, product.getPrecio());
            stmt.setInt(3, product.getCantidad());
            stmt.setString(4, product.getDescripcion());
            stmt.setString(5, product.getImagen_base64());
            stmt.setInt(6, product.getId_producto());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            Connection conn = Database.getConnection();
            String sql = "DELETE FROM producto WHERE id_producto = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
