package com.example.sample.repository;

import com.example.sample.models.Product;
import com.example.sample.projections.ProductWithCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select p.title as title, p.description as description, p.price as price, c.title as category from Product p join Category c on p.category.id=c.id where p.id= :id")
    ProductWithCategory getProductWithCategoryById(@Param("id") Long id);
}
