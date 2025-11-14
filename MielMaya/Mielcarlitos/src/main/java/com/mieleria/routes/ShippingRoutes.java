package com.mieleria.routes;

import com.mieleria.controllers.ShippingController;
import io.javalin.Javalin;

public class ShippingRoutes {

    private ShippingController shippingController = new ShippingController();

    public void register(Javalin app) {
        app.post("/shipping", shippingController::createAddress);
        app.get("/shipping", shippingController::getAllAddresses);
        app.get("/shipping/{id}", shippingController::getAddressById);
        app.put("/shipping/{id}", shippingController::updateAddress);
        app.delete("/shipping/{id}", shippingController::deleteAddress);
    }
}
