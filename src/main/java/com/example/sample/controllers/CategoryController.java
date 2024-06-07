package com.example.sample.controllers;

import com.example.sample.DTO.CategoryProdDTO;
import com.example.sample.models.Category;
import com.example.sample.services.category.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public List<Category> getAllCategories() {
        return new ArrayList<>();
    }

    @GetMapping("/single/{id}")
    public Category getCategoryDetailsById(@PathVariable("id") Long id){
        return categoryService.getCategoryById(id);
    }

    @GetMapping("/{id}")
    public CategoryProdDTO getCategoryById(@PathVariable("id") Long id) {
        return categoryService.getCompleteCategoryById(id);
    }

}
