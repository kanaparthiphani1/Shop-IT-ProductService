package com.example.sample.projections;

import com.example.sample.models.Category;

public interface ProductWithCategory {
    String getTitle();
    String getDescription();
    Double getPrice();

    String getCategory();

}
