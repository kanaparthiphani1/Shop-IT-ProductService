package com.example.sample.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ModifyRatingDTO {
    private Long id;
    private Long productId;
    private String review;
    private int rating;
}
