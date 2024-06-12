package com.example.sample.services.products;


import com.example.sample.DTO.CreateProductDTO;
import com.example.sample.DTO.ProductWithCategoryDTO;
import com.example.sample.exception.ProductNotFoundException;
import com.example.sample.models.Product;
import com.example.sample.projections.ProductWithCategory;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    ProductWithCategoryDTO getProductById(Long id) throws ProductNotFoundException;
    Page<Product> getAllProducts(int pageNum,int pageSize, String dir);
    Product createProduct(CreateProductDTO product);
    Product replaceProduct(Product product) throws ProductNotFoundException;
}
