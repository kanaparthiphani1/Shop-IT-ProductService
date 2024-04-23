package com.example.sample.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Long Id;
    private String title;
    private String description;
    private double price;
    private String imageUrl;
    private Category category;
}
