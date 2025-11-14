package com.mieleria.service;

import com.mieleria.models.CancelledProduct;
import com.mieleria.repository.CancelledProductRepository;
import java.util.List;

public class CancelledProductService {

    private CancelledProductRepository cancelledProductRepository = new CancelledProductRepository();

    public void createCancelled(CancelledProduct cancelled) {
        cancelledProductRepository.create(cancelled);
    }

    public List<CancelledProduct> getAllCancelled() {
        return cancelledProductRepository.findAll();
    }

    public CancelledProduct getCancelledById(int id) {
        return cancelledProductRepository.findById(id);
    }

    public void updateCancelled(CancelledProduct cancelled) {
        cancelledProductRepository.update(cancelled);
    }

    public void deleteCancelled(int id) {
        cancelledProductRepository.delete(id);
    }
}
