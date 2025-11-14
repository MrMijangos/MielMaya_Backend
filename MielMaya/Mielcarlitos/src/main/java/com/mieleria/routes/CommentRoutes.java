package com.mieleria.routes;

import com.mieleria.controllers.CommentController;
import io.javalin.Javalin;

public class CommentRoutes {

    private CommentController commentController = new CommentController();

    public void register(Javalin app) {
        app.post("/comments", commentController::createComment);
        app.get("/comments", commentController::getAllComments);
        app.get("/comments/{id}", commentController::getCommentById);
        app.put("/comments/{id}", commentController::updateComment);
        app.delete("/comments/{id}", commentController::deleteComment);
    }
}
