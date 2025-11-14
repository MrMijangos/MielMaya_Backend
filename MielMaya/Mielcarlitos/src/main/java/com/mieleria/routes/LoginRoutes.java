package com.mieleria.routes;

import com.mieleria.controllers.LoginController;
import io.javalin.Javalin;

public class LoginRoutes {

    private LoginController loginController = new LoginController();

    public void register(Javalin app) {
        app.post("/login", loginController::login);
        app.post("/logout", loginController::logout);
        app.get("/verify", loginController::verifyToken);
    }
}
