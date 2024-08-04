package com.example.sample.services.rating;

import com.example.sample.DTO.CreateRatingDTO;
import com.example.sample.DTO.ModifyRatingDTO;
import com.example.sample.exception.RatingNotFoundException;
import com.example.sample.models.Rating;
import org.springframework.data.domain.Page;

public interface RatingService {
    public Rating getRating(Long ratingId);
    public Page<Rating> getAllRatingsByProduct(int pageNum, int pageSize, String dir, Long productId);
    public Rating createRating(CreateRatingDTO rating);
    public Rating modifyRating(ModifyRatingDTO rating) throws RatingNotFoundException;
}
