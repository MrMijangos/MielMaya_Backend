package com.mieleria.controllers;

import com.mieleria.models.User;
import com.mieleria.service.UserService;
import io.javalin.http.Context;
import java.util.List;

public class UserController {

    private UserService userService = new UserService();

    // Crear un usuario nuevo
    public void createUser(Context ctx) {
        User user = ctx.bodyAsClass(User.class);
        userService.createUser(user);
        ctx.status(201).json(user);
    }

    // Obtener todos los usuarios
    public void getAllUsers(Context ctx) {
        List<User> users = userService.getAllUsers();
        ctx.json(users);
    }

    // Obtener usuario por ID
    public void getUserById(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        User user = userService.getUserById(id);

        if (user != null)
            ctx.json(user);
        else
            ctx.status(404).result("Usuario no encontrado");
    }

    // Actualizar usuario existente
    public void updateUser(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        User user = ctx.bodyAsClass(User.class);
        user.setId_user(id);
        userService.updateUser(user);
        ctx.json(user);
    }

    // Eliminar usuario
    public void deleteUser(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        userService.deleteUser(id);
        ctx.status(204);
    }

    // Iniciar sesión (login)
    public void login(Context ctx) {
        User user = ctx.bodyAsClass(User.class);
        String token = userService.login(user.getCorreo(), user.getContraseña());

        if (token != null)
            ctx.json("{\"token\":\"" + token + "\"}");
        else
            ctx.status(401).result("Credenciales incorrectas");
    }
}
