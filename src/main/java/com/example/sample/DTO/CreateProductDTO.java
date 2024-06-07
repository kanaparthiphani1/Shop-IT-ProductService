package com.example.sample.DTO;

import com.example.sample.models.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductDTO {
    private String title;
    private String description;
    private double price;
    private String imageUrl;
    private Category category;
}
