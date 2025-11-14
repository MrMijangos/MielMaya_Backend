package com.mieleria.repository;

import com.mieleria.models.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    public void create(User user) {
        try {
            Connection conn = Database.getConnection();
            String sql = "INSERT INTO createAccount (nombre, correo, contraseña, token) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getNombre());
            stmt.setString(2, user.getCorreo());
            stmt.setString(3, user.getContraseña());
            stmt.setString(4, null); // token inicial null
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try {
            Connection conn = Database.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM createAccount");
            while (rs.next()) {
                User u = new User();
                u.setId_user(rs.getInt("id_user"));
                u.setNombre(rs.getString("Nombre"));
                u.setCorreo(rs.getString("correo"));
                u.setContraseña(rs.getString("contraseña"));
                u.setToken(rs.getString("token")); // 🔹 token
                users.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public User findById(int id) {
        User user = null;
        try {
            Connection conn = Database.getConnection();
            String sql = "SELECT * FROM createAccount WHERE id_user = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId_user(rs.getInt("id_user"));
                user.setNombre(rs.getString("Nombre"));
                user.setCorreo(rs.getString("correo"));
                user.setContraseña(rs.getString("contraseña"));
                user.setToken(rs.getString("token")); // 🔹 token
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    // 🔹 Nuevo: buscar por correo
    public User findByEmail(String correo) {
        User user = null;
        try {
            Connection conn = Database.getConnection();
            String sql = "SELECT * FROM createAccount WHERE correo = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, correo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId_user(rs.getInt("id_user"));
                user.setNombre(rs.getString("Nombre"));
                user.setCorreo(rs.getString("correo"));
                user.setContraseña(rs.getString("contraseña"));
                user.setToken(rs.getString("token"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    // 🔹 Nuevo: actualizar token
    public void updateToken(String correo, String token) {
        try {
            Connection conn = Database.getConnection();
            String sql = "UPDATE createAccount SET token = ? WHERE correo = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, token);
            stmt.setString(2, correo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Actualizar usuario
    public void update(User user) {
        try {
            Connection conn = Database.getConnection();
            String sql = "UPDATE createAccount SET Nombre = ?, correo = ?, contraseña = ?, token = ? WHERE id_user = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getNombre());
            stmt.setString(2, user.getCorreo());
            stmt.setString(3, user.getContraseña());
            stmt.setString(4, user.getToken()); // actualizar token si existe
            stmt.setInt(5, user.getId_user());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Eliminar usuario por id
    public void delete(int id) {
        try {
            Connection conn = Database.getConnection();
            String sql = "DELETE FROM createAccount WHERE id_user = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Los métodos update() y delete() permanecen igual
}
