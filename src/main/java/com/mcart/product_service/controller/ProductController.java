package com.mcart.product_service.controller;

import com.mcart.product_service.entity.Product;
import com.mcart.product_service.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping
    public String saveProduct(@RequestBody Product product) {
        productService.saveProduct(product);
        return "Product saved successfully!";
    }
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable int id) {
        return productService.getProduct(id);
    }
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
        return "Product deleted successfully!";
    }
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
}
