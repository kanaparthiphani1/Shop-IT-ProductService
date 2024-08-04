package com.example.sample.repository;

import com.example.sample.models.Rating;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
    Page<Rating> findByProductId(Long productId, PageRequest pageRequest);
}
