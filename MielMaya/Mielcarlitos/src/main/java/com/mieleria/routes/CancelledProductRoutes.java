package com.mieleria.routes;

import com.mieleria.controllers.CancelledProductController;
import io.javalin.Javalin;

public class CancelledProductRoutes {

    private CancelledProductController cancelledController = new CancelledProductController();

    public void register(Javalin app) {
        app.post("/cancelled", cancelledController::createCancelled);
        app.get("/cancelled", cancelledController::getAllCancelled);
        app.get("/cancelled/{id}", cancelledController::getCancelledById);
        app.put("/cancelled/{id}", cancelledController::updateCancelled);
        app.delete("/cancelled/{id}", cancelledController::deleteCancelled);
    }
}
