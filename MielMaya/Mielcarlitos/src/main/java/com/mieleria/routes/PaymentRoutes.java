package com.mieleria.routes;

import com.mieleria.controllers.PaymentController;
import io.javalin.Javalin;

public class PaymentRoutes {

    private PaymentController paymentController = new PaymentController();

    public void register(Javalin app) {
        app.post("/payments", paymentController::createPayment);
        app.get("/payments", paymentController::getAllPayments);
        app.get("/payments/{id}", paymentController::getPaymentById);
        app.put("/payments/{id}", paymentController::updatePayment);
        app.delete("/payments/{id}", paymentController::deletePayment);
    }
}
