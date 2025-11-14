package com.mieleria.repository;

import com.mieleria.models.Comment;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentRepository {

    public void create(Comment comment) {
        try {
            Connection conn = Database.getConnection();
            String sql = "INSERT INTO comentarios (Descripcion, id_user, calificacion) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, comment.getDescripcion());
            stmt.setInt(2, comment.getId_user());
            stmt.setString(3, comment.getCalificacion());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Comment> findAll() {
        List<Comment> comments = new ArrayList<>();
        try {
            Connection conn = Database.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM comentarios");
            while (rs.next()) {
                Comment c = new Comment();
                c.setId_comentario(rs.getInt("id_comentario"));
                c.setDescripcion(rs.getString("Descripcion"));
                c.setId_user(rs.getInt("id_user"));
                c.setCalificacion(rs.getString("calificacion"));
                comments.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comments;
    }

    public Comment findById(int id) {
        Comment comment = null;
        try {
            Connection conn = Database.getConnection();
            String sql = "SELECT * FROM comentarios WHERE id_comentario = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                comment = new Comment();
                comment.setId_comentario(rs.getInt("id_comentario"));
                comment.setDescripcion(rs.getString("Descripcion"));
                comment.setId_user(rs.getInt("id_user"));
                comment.setCalificacion(rs.getString("calificacion"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comment;
    }

    public void update(Comment comment) {
        try {
            Connection conn = Database.getConnection();
            String sql = "UPDATE comentarios SET Descripcion = ?, id_user = ?, calificacion = ? WHERE id_comentario = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, comment.getDescripcion());
            stmt.setInt(2, comment.getId_user());
            stmt.setString(3, comment.getCalificacion());
            stmt.setInt(4, comment.getId_comentario());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            Connection conn = Database.getConnection();
            String sql = "DELETE FROM comentarios WHERE id_comentario = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
