package com.example.sample.services.category;

import com.example.sample.DTO.CategoryProdDTO;
import com.example.sample.models.Category;
import org.springframework.data.domain.Page;

public interface CategoryService {
    Page<Category> getCategories(int pageNumber, int pageSize, String order);
    public Category getCategoryById(Long id);
    public CategoryProdDTO getCompleteCategoryById(Long id);
}
