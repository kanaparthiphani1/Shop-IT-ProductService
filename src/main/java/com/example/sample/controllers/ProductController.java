package com.example.sample.controllers;

import com.example.sample.models.Product;
import com.example.sample.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        return this.productService.getProductById(id);
    }

    @GetMapping()
    public List<Product> getProducts() {
        return this.productService.getAllProducts();
    }


}
