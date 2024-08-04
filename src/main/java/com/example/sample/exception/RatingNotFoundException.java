package com.example.sample.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RatingNotFoundException extends Exception {
    private Long ratingId;
    public RatingNotFoundException(String message, Long id) {
        super(message);
        this.ratingId = id;
    }
}
