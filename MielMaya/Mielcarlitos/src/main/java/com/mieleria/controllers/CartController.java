package com.mieleria.controllers;

import com.mieleria.models.CartItem;
import com.mieleria.service.CartService;
import io.javalin.http.Context;
import java.util.List;

public class CartController {

    private CartService cartService = new CartService();

    public void addItem(Context ctx) {
        CartItem item = ctx.bodyAsClass(CartItem.class);
        cartService.addItem(item);
        ctx.status(201).json(item);
    }

    public void getAllItems(Context ctx) {
        ctx.json(cartService.getAllItems());
    }

    public void getItemById(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        CartItem item = cartService.getItemById(id);
        if (item != null) ctx.json(item);
        else ctx.status(404).result("Item no encontrado");
    }

    public void updateItem(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        CartItem item = ctx.bodyAsClass(CartItem.class);
        item.setId_carrito(id);
        cartService.updateItem(item);
        ctx.json(item);
    }

    public void deleteItem(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        cartService.deleteItem(id);
        ctx.status(204);
    }
}
