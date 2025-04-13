package com.mcart.product_service.service;

import com.mcart.product_service.entity.Product;
import com.mcart.product_service.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ProductService {
    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public void saveProduct(Product product) {
        productRepository.save(product);
    }
    public Product getProduct(int productId) {
        return productRepository.findById(productId);
    }
    public void deleteProduct(String productId) {
        productRepository.delete(productId);
    }
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
