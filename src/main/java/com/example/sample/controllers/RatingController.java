package com.example.sample.controllers;

import com.example.sample.DTO.CreateRatingDTO;
import com.example.sample.models.Product;
import com.example.sample.models.Rating;
import com.example.sample.services.products.ProductService;
import com.example.sample.services.rating.RatingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
            name = "CRUD REST APIs for Product Ratings in ShopIT",
            description = "CRUD REST APIs in ShopIT to CREATE, UPDATE, FETCH AND DELETE product ratings"
    )
    @RestController
    @RequestMapping(path = "/rating")
    public class RatingController {

        private RatingService ratingService;

        public RatingController(RatingService ratingService) {
            this.ratingService = ratingService;
        }

        @Operation(
                summary = "Get Product Ratings REST API",
                description = "REST API to get product ratings"
        )
        @ApiResponses({
                @ApiResponse(
                        responseCode = "200",
                        description = "HTTP Status CREATED"
                ),
                @ApiResponse(
                        responseCode = "500",
                        description = "HTTP Status Internal Server Error"

                )
        }
        )
        @GetMapping("/{productId}")
        public Page<Rating> getProductRatings(@RequestParam("pageNumber") int pageNumber,
                                              @RequestParam("pageSize") int pageSize,
                                              @RequestParam("sortDir") String sortDir,
                                              @PathVariable("productId") Long productId) {
            return ratingService.getAllRatingsByProduct(pageNumber, pageSize, sortDir,productId);
        }

    @Operation(
            summary = "Create Product Ratings REST API",
            description = "REST API to create product ratings"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status CREATED"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error"

            )
    }
    )
    @PostMapping("/{productId}")
    public ResponseEntity<Rating> createProductRatings(CreateRatingDTO createRatingDTO) {
        return ResponseEntity.ok(ratingService.createRating(createRatingDTO));
    }


}
