package com.mieleria.controllers;

import com.mieleria.models.Comment;
import com.mieleria.service.CommentService;
import io.javalin.http.Context;
import java.util.List;

public class CommentController {

    private CommentService commentService = new CommentService();

    // Crear un comentario
    public void createComment(Context ctx) {
        Comment comment = ctx.bodyAsClass(Comment.class);
        commentService.createComment(comment);
        ctx.status(201).json(comment);
    }

    // Obtener todos los comentarios
    public void getAllComments(Context ctx) {
        List<Comment> comments = commentService.getAllComments();
        ctx.json(comments);
    }

    // Obtener un comentario por ID
    public void getCommentById(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Comment comment = commentService.getCommentById(id);
        if (comment != null)
            ctx.json(comment);
        else
            ctx.status(404).result("Comentario no encontrado");
    }

    // Actualizar un comentario
    public void updateComment(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Comment comment = ctx.bodyAsClass(Comment.class);
        comment.setId_comentario(id);
        commentService.updateComment(comment);
        ctx.json(comment);
    }

    // Eliminar un comentario
    public void deleteComment(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        commentService.deleteComment(id);
        ctx.status(204);
    }
}
