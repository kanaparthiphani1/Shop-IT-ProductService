package com.example.sample.services.products;


import com.example.sample.DTO.CreateProductDTO;
import com.example.sample.exception.ProductNotFoundException;
import com.example.sample.models.Product;
import com.example.sample.projections.ProductWithCategory;

import java.util.List;

public interface ProductService {
    ProductWithCategory getProductById(Long id);
    List<Product> getAllProducts();
    Product createProduct(CreateProductDTO product);
    Product replaceProduct(Product product) throws ProductNotFoundException;
}
