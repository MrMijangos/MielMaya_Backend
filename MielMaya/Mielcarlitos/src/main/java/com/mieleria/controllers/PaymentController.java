package com.mieleria.controllers;

import com.mieleria.models.PaymentMethod;
import com.mieleria.service.PaymentService;
import io.javalin.http.Context;
import java.util.List;

public class PaymentController {

    private PaymentService paymentService = new PaymentService();

    // Crear un método de pago
    public void createPayment(Context ctx) {
        PaymentMethod payment = ctx.bodyAsClass(PaymentMethod.class);
        paymentService.createPayment(payment);
        ctx.status(201).json(payment);
    }

    // Obtener todos los métodos de pago
    public void getAllPayments(Context ctx) {
        ctx.json(paymentService.getAllPayments());
    }

    // Obtener un método de pago por ID
    public void getPaymentById(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        PaymentMethod payment = paymentService.getPaymentById(id);

        if (payment != null)
            ctx.json(payment);
        else
            ctx.status(404).result("Método de pago no encontrado");
    }

    // Actualizar un método de pago
    public void updatePayment(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        PaymentMethod payment = ctx.bodyAsClass(PaymentMethod.class);
        payment.setId_pago(id);
        paymentService.updatePayment(payment);
        ctx.json(payment);
    }

    // Eliminar un método de pago
    public void deletePayment(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        paymentService.deletePayment(id);
        ctx.status(204);
    }
}
