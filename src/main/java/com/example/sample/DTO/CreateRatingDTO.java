package com.example.sample.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateRatingDTO {
    private Long productId;
    private String review;
    private int rating;
}
