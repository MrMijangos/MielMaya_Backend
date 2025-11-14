package com.mieleria.repository;

import com.mieleria.models.Login;
import java.sql.*;

public class LoginRepository {

    public void saveToken(String correo, String token) {
        try {
            Connection conn = Database.getConnection();
            String sql = "UPDATE login SET token = ? WHERE correo = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, token);
            stmt.setString(2, correo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Login findByCorreo(String correo) {
        Login login = null;
        try {
            Connection conn = Database.getConnection();
            String sql = "SELECT * FROM login WHERE correo = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, correo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                login = new Login();
                login.setCorreo(rs.getString("correo"));
                login.setContraseña(rs.getString("contraseña"));
                login.setToken(rs.getString("token"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return login;
    }

    public void create(Login login) {
        try {
            Connection conn = Database.getConnection();
            String sql = "INSERT INTO login (correo, contraseña, token) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, login.getCorreo());
            stmt.setString(2, login.getContraseña());
            stmt.setString(3, login.getToken());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
