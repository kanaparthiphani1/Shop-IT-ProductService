package com.example.sample.DTO;

import com.example.sample.projections.ProductWithCategory;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductWithCategoryDTO implements Serializable {
    private String title;
    private String description;
    private Double price;
    private String category;

    public ProductWithCategoryDTO(ProductWithCategory productWithCategory){
        this.title = productWithCategory.getTitle();
        this.description = productWithCategory.getDescription();
        this.price = productWithCategory.getPrice();
        this.category = productWithCategory.getCategory();
    }

}
