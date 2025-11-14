package com.mieleria.service;

import com.mieleria.models.PaymentMethod;
import com.mieleria.repository.PaymentRepository;
import java.util.List;

public class PaymentService {

    private PaymentRepository paymentRepository = new PaymentRepository();

    public void createPayment(PaymentMethod payment) {
        paymentRepository.create(payment);
    }

    public List<PaymentMethod> getAllPayments() {
        return paymentRepository.findAll();
    }

    public PaymentMethod getPaymentById(int id) {
        return paymentRepository.findById(id);
    }

    public void updatePayment(PaymentMethod payment) {
        paymentRepository.update(payment);
    }

    public void deletePayment(int id) {
        paymentRepository.delete(id);
    }
}
