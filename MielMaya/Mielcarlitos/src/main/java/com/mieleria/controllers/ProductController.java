package com.mieleria.controllers;

import com.mieleria.models.Product;
import com.mieleria.service.ProductService;
import io.javalin.http.Context;
import java.util.List;

public class ProductController {

    private ProductService productService = new ProductService();

    // Crear producto
    public void createProduct(Context ctx) {
        Product product = ctx.bodyAsClass(Product.class);
        productService.createProduct(product);
        ctx.status(201).json(product);
    }

    // Obtener todos los productos
    public void getAllProducts(Context ctx) {
        List<Product> products = productService.getAllProducts();
        ctx.json(products);
    }

    // Obtener producto por ID
    public void getProductById(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Product product = productService.getProductById(id);

        if (product != null)
            ctx.json(product);
        else
            ctx.status(404).result("Producto no encontrado");
    }

    // Actualizar producto
    public void updateProduct(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Product product = ctx.bodyAsClass(Product.class);
        product.setId_producto(id);
        productService.updateProduct(product);
        ctx.json(product);
    }

    // Eliminar producto
    public void deleteProduct(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        productService.deleteProduct(id);
        ctx.status(204);
    }
}
