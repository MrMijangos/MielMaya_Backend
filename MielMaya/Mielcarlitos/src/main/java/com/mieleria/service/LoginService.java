package com.mieleria.service;

import com.mieleria.models.Login;
import com.mieleria.repository.Database;
import com.mieleria.repository.LoginRepository;
import com.mieleria.utils.TokenUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.UUID;

public class LoginService {

    private LoginRepository loginRepository = new LoginRepository();

    /**
     * Intenta iniciar sesión con correo y contraseña.
     * Si es correcto, genera un token único y lo guarda en la BD.
     * @param correo correo del usuario
     * @param contraseña contraseña del usuario
     * @return token si login es exitoso, null si falla
     */
    public String login(String correo, String contraseña) {
        Login login = loginRepository.findByCorreo(correo);
        if (login != null && login.getContraseña().equals(contraseña)) {
            String token = TokenUtil.generateToken(correo);
            loginRepository.saveToken(correo, token);
            return token;
        }
        return null;
    }

    /**
     * Verifica si un token es válido
     * @param token token a verificar
     * @return true si existe en la BD, false si no
     */
    public boolean verifyToken(String token) {
        try {
            Connection conn = Database.getConnection();
            String sql = "SELECT * FROM login WHERE token = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, token);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Cierra sesión eliminando el token
     * @param token token del usuario
     */
    public void logout(String token) {
        try {
            Connection conn = Database.getConnection();
            String sql = "UPDATE login SET token = NULL WHERE token = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, token);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
