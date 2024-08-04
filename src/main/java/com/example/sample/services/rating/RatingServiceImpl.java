package com.example.sample.services.rating;

import com.example.sample.DTO.CreateRatingDTO;
import com.example.sample.DTO.ModifyRatingDTO;
import com.example.sample.exception.RatingNotFoundException;
import com.example.sample.models.Rating;
import com.example.sample.repository.ProductRepository;
import com.example.sample.repository.RatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService{

    private RatingRepository ratingRepository;
    private ProductRepository productRepository;

    @Override
    public Rating getRating(Long ratingId) {
        Optional<Rating> optionalRating = ratingRepository.findById(ratingId);
        return optionalRating.orElse(null);
    }

    @Override
    public Page<Rating> getAllRatingsByProduct(int pageNum, int pageSize, String dir, Long productId) {
        return ratingRepository.findByProductId(productId, PageRequest.of(pageNum,pageSize,dir.equalsIgnoreCase("asc")?
                Sort.by("rating").ascending() :
                Sort.by("rating").descending()));
    }

    @Override
    public Rating createRating(CreateRatingDTO rating) {
        Rating newRating = new Rating();
        newRating.setRating(rating.getRating());
        newRating.setReview(rating.getReview());
        newRating.setProduct(productRepository.findById(rating.getProductId()).orElse(null));
        return ratingRepository.save(newRating);
    }

    @Override
    public Rating modifyRating(ModifyRatingDTO rating) throws RatingNotFoundException {
        Rating rating1 = ratingRepository.findById(rating.getId()).orElse(null);
        if(rating1==null) throw new RatingNotFoundException("Rating Not Found",rating.getId());
        rating1.setRating(rating.getRating());
        rating1.setReview(rating.getReview());
        return ratingRepository.save(rating1);
    }
}
