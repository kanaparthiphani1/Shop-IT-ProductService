package com.example.sample.DTO;

import com.example.sample.models.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryProdDTO {
    private Long id;
    private String title;
    private List<Product> products;
}
