package com.mieleria.routes;

import com.mieleria.controllers.ProductController;
import io.javalin.Javalin;

public class ProductRoutes {

    private ProductController productController = new ProductController();

    public void register(Javalin app) {
        app.post("/products", productController::createProduct);
        app.get("/products", productController::getAllProducts);
        app.get("/products/{id}", productController::getProductById);
        app.put("/products/{id}", productController::updateProduct);
        app.delete("/products/{id}", productController::deleteProduct);
    }
}
