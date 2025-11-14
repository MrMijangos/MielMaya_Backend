package com.mieleria.routes;

import com.mieleria.controllers.UserController;
import io.javalin.Javalin;

public class UserRoutes {

    private UserController userController = new UserController();

    public void register(Javalin app) {
        app.post("/users", userController::createUser);
        app.get("/users", userController::getAllUsers);
        app.get("/users/{id}", userController::getUserById);
        app.put("/users/{id}", userController::updateUser);
        app.delete("/users/{id}", userController::deleteUser);
        app.post("/login", userController::login);
    }
}
