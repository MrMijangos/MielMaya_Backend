package com.mieleria.controllers;

import com.mieleria.models.CancelledProduct;
import com.mieleria.service.CancelledProductService;
import io.javalin.http.Context;

public class CancelledProductController {

    private CancelledProductService cancelledService = new CancelledProductService();

    // Crear un producto cancelado
    public void createCancelled(Context ctx) {
        CancelledProduct cancelled = ctx.bodyAsClass(CancelledProduct.class);
        cancelledService.createCancelled(cancelled);
        ctx.status(201).json(cancelled);
    }

    // Obtener todos los productos cancelados
    public void getAllCancelled(Context ctx) {
        ctx.json(cancelledService.getAllCancelled());
    }

    // Obtener producto cancelado por ID
    public void getCancelledById(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        CancelledProduct cancelled = cancelledService.getCancelledById(id);
        if (cancelled != null)
            ctx.json(cancelled);
        else
            ctx.status(404).result("Producto cancelado no encontrado");
    }

    // Actualizar producto cancelado
    public void updateCancelled(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        CancelledProduct cancelled = ctx.bodyAsClass(CancelledProduct.class);
        cancelled.setId_cancelado(id);
        cancelledService.updateCancelled(cancelled);
        ctx.json(cancelled);
    }

    // Eliminar producto cancelado
    public void deleteCancelled(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        cancelledService.deleteCancelled(id);
        ctx.status(204);
    }
}
