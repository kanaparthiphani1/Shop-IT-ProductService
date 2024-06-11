package com.example.sample.controllers;

import com.example.sample.DTO.CreateProductDTO;
import com.example.sample.exception.ProductNotFoundException;
import com.example.sample.models.Product;
import com.example.sample.projections.ProductWithCategory;
import com.example.sample.services.products.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping()
    public ResponseEntity<Product> createProduct(@RequestBody CreateProductDTO product) {
        Product product1 = productService.createProduct(product);
        return ResponseEntity.ok(product1);
    }

    @GetMapping("/{id}")
    public ProductWithCategory getProductById(@PathVariable("id") Long id) {
        return this.productService.getProductById(id);
    }

    @GetMapping()
    public Page<Product> getProducts(@RequestParam("pageNumber") int pageNumber,
                                     @RequestParam("pageSize") int pageSize,
                                     @RequestParam("sortDir") String sortDir) {
        return this.productService.getAllProducts(pageNumber, pageSize, sortDir);
    }

    @PutMapping()
    public ResponseEntity<Product> replaceProduct(@RequestBody Product product) throws ProductNotFoundException {
        Product newProd = productService.replaceProduct(product);
        return ResponseEntity.ok(newProd);
    }


}
