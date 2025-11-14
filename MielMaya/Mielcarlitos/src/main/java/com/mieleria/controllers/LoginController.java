package com.mieleria.controllers;

import com.mieleria.models.Login;
import com.mieleria.service.LoginService;
import io.javalin.http.Context;

public class LoginController {

    private LoginService loginService = new LoginService();

    // Iniciar sesión (login)
    public void login(Context ctx) {
        Login loginRequest = ctx.bodyAsClass(Login.class);
        String token = loginService.login(loginRequest.getCorreo(), loginRequest.getContraseña());

        if (token != null) {
            ctx.json("{\"token\":\"" + token + "\"}");
        } else {
            ctx.status(401).result("Credenciales incorrectas");
        }
    }

    // Cerrar sesión (logout)
    public void logout(Context ctx) {
        String token = ctx.header("Authorization");

        if (token != null && !token.isEmpty()) {
            loginService.logout(token);
            ctx.status(200).result("Sesión cerrada correctamente");
        } else {
            ctx.status(400).result("Token no proporcionado");
        }
    }

    // Verificar token
    public void verifyToken(Context ctx) {
        String token = ctx.header("Authorization");

        if (token != null && !token.isEmpty()) {
            boolean valid = loginService.verifyToken(token);

            if (valid) ctx.status(200).result("Token válido");
            else ctx.status(401).result("Token inválido");
        } else {
            ctx.status(400).result("Token no proporcionado");
        }
    }
}
