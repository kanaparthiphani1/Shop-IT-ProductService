package com.example.sample.DTO;

import com.example.sample.models.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FakeStoreProductDTO {
        private Long Id;
        private String title;
        private String description;
        private double price;
        private String image;
        private String category;
}
