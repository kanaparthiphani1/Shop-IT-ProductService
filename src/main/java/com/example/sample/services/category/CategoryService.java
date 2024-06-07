package com.example.sample.services.category;

import com.example.sample.DTO.CategoryProdDTO;
import com.example.sample.models.Category;

public interface CategoryService {
    public Category getCategoryById(Long id);
    public CategoryProdDTO getCompleteCategoryById(Long id);
}
