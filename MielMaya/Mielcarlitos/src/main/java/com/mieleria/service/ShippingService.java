package com.mieleria.service;

import com.mieleria.models.ShippingAddress;
import com.mieleria.repository.ShippingRepository;
import java.util.List;

public class ShippingService {

    private ShippingRepository shippingRepository = new ShippingRepository();

    public void createAddress(ShippingAddress address) {
        shippingRepository.create(address);
    }

    public List<ShippingAddress> getAllAddresses() {
        return shippingRepository.findAll();
    }

    public ShippingAddress getAddressById(int id) {
        return shippingRepository.findById(id);
    }

    public void updateAddress(ShippingAddress address) {
        shippingRepository.update(address);
    }

    public void deleteAddress(int id) {
        shippingRepository.delete(id);
    }
}
