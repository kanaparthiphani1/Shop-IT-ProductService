package com.example.sample.controllers;

import com.example.sample.DTO.CategoryProdDTO;
import com.example.sample.DTO.CreateCategory;
import com.example.sample.models.Category;
import com.example.sample.services.category.CategoryService;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping()
    public Page<Category> getAllCategories(@RequestParam("pageNumber") int pageNumber, @RequestParam("pageSize") int pageSize, @RequestParam("order") String order) {
        return categoryService.getCategories(pageNumber,pageSize,order);
    }

    @GetMapping("/single/{id}")
    public Category getCategoryDetailsById(@PathVariable("id") Long id){
        return categoryService.getCategoryById(id);
    }

    @GetMapping("/{id}")
    public CategoryProdDTO getCategoryById(@PathVariable("id") Long id) {
        return categoryService.getCompleteCategoryById(id);
    }

    @PostMapping()
    @PreAuthorize("hasRole('ADMIN')")
    public Category createCategory(@RequestBody CreateCategory categoryDTO) {
        return categoryService.createCategory(categoryDTO);
    }

}
