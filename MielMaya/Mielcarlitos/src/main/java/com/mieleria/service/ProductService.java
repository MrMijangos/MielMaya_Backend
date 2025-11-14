package com.mieleria.service;

import com.mieleria.models.Product;
import com.mieleria.repository.ProductRepository;
import java.util.List;

public class ProductService {

    private ProductRepository productRepository = new ProductRepository();

    public void createProduct(Product product) {
        productRepository.create(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(int id) {
        return productRepository.findById(id);
    }

    public void updateProduct(Product product) {
        productRepository.update(product);
    }

    public void deleteProduct(int id) {
        productRepository.delete(id);
    }
}
