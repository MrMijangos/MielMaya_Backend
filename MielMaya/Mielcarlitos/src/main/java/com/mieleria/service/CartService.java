package com.mieleria.service;

import com.mieleria.models.CartItem;
import com.mieleria.repository.CartRepository;
import java.util.List;

public class CartService {

    private CartRepository cartRepository = new CartRepository();

    public void addItem(CartItem item) {
        cartRepository.create(item);
    }

    public List<CartItem> getAllItems() {
        return cartRepository.findAll();
    }

    public CartItem getItemById(int id) {
        return cartRepository.findById(id);
    }

    public void updateItem(CartItem item) {
        cartRepository.update(item);
    }

    public void deleteItem(int id) {
        cartRepository.delete(id);
    }
}
