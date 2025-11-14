package com.mieleria.routes;

import com.mieleria.controllers.CartController;
import io.javalin.Javalin;

public class CartRoutes {

    private CartController cartController = new CartController();

    public void register(Javalin app) {
        app.post("/cart", cartController::addItem);
        app.get("/cart", cartController::getAllItems);
        app.get("/cart/{id}", cartController::getItemById);
        app.put("/cart/{id}", cartController::updateItem);
        app.delete("/cart/{id}", cartController::deleteItem);
    }
}
