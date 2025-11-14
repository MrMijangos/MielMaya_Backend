package com.mieleria.controllers;

import com.mieleria.models.ShippingAddress;
import com.mieleria.service.ShippingService;
import io.javalin.http.Context;
import java.util.List;

public class ShippingController {

    private ShippingService shippingService = new ShippingService();

    // Crear una dirección de envío
    public void createAddress(Context ctx) {
        ShippingAddress address = ctx.bodyAsClass(ShippingAddress.class);
        shippingService.createAddress(address);
        ctx.status(201).json(address);
    }

    // Obtener todas las direcciones de envío
    public void getAllAddresses(Context ctx) {
        List<ShippingAddress> addresses = shippingService.getAllAddresses();
        ctx.json(addresses);
    }

    // Obtener una dirección por ID
    public void getAddressById(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        ShippingAddress address = shippingService.getAddressById(id);

        if (address != null)
            ctx.json(address);
        else
            ctx.status(404).result("Dirección no encontrada");
    }

    // Actualizar una dirección
    public void updateAddress(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        ShippingAddress address = ctx.bodyAsClass(ShippingAddress.class);
        address.setId_direccion(id);
        shippingService.updateAddress(address);
        ctx.json(address);
    }

    // Eliminar una dirección
    public void deleteAddress(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        shippingService.deleteAddress(id);
        ctx.status(204);
    }
}
