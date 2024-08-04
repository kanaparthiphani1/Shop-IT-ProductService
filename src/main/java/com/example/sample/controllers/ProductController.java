package com.example.sample.controllers;

import com.example.sample.DTO.CreateProductDTO;
import com.example.sample.DTO.ProductWithCategoryDTO;
import com.example.sample.DTO.ResponseDto;
import com.example.sample.exception.ProductNotFoundException;
import com.example.sample.models.Product;
import com.example.sample.projections.ProductWithCategory;
import com.example.sample.services.products.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Tag(
        name = "CRUD REST APIs for Ptoducts in ShopIT",
        description = "CRUD REST APIs in ShopIT to CREATE, UPDATE, FETCH AND DELETE products"
)
@RestController
@RequestMapping(path = "/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(
            summary = "Get Product REST API",
            description = "REST API to get product"
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
    @GetMapping()
    public Page<Product> getProducts(@RequestParam("pageNumber") int pageNumber,
                                     @RequestParam("pageSize") int pageSize,
                                     @RequestParam("sortDir") String sortDir) {
        return this.productService.getAllProducts(pageNumber, pageSize, sortDir);
    }

    @Operation(
            summary = "Get Productbyid REST API",
            description = "REST API to get product by id"
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
    @GetMapping("/{id}")
    public ProductWithCategoryDTO getProductById(@PathVariable("id") Long id) {
        try{
            System.out.println("Id : "+id);
        return this.productService.getProductById(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Operation(
            summary = "Get Products By category ID REST API",
            description = "REST API to get product by id"
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
    @GetMapping("/category/{categoryId}")
    public Page<Product> getProductsByCategory(@RequestParam("pageNumber") int pageNumber,
                                               @RequestParam("pageSize") int pageSize,
                                               @RequestParam("sortDir") String sortDir,
                                               @PathVariable("categoryId") Long categoryId) {
        return productService.getProductsByCategory(pageNumber, pageSize, sortDir, categoryId);

    }

    @Operation(
            summary = "Create Products",
            description = "REST API to create Product"
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
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping()
    public ResponseEntity<Product> createProduct(@RequestBody CreateProductDTO product, Principal principal, Authentication auth, @AuthenticationPrincipal Jwt jwt) {
        System.out.println(principal.getName());
        Long userId = (Long) jwt.getClaims().get("userId");
        System.out.println(Optional.ofNullable(jwt.getClaim("userId")));
        Product product1 = productService.createProduct(product);
        return ResponseEntity.ok(product1);
    }

    @Operation(
            summary = "Replace Products",
            description = "REST API to replace Product"
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
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping()
    public ResponseEntity<Product> replaceProduct(@RequestBody Product product) throws ProductNotFoundException {
        Product newProd = productService.replaceProduct(product);
        return ResponseEntity.ok(newProd);
    }


    @Operation(
            summary = "Delete Products",
            description = "REST API to delete Product"
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
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteProduct(@PathVariable("id") Long id){
        ResponseDto res = new ResponseDto();
        if(productService.deleteProduct(id)){
            res.setStatusMsg("Successfully deleted product with id : "+id);
            res.setStatusCode(HttpStatus.OK);
        }else{
            res.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
            res.setStatusMsg("Failed to delete product with id : "+id);
        }
        return ResponseEntity.ok(res);
    }

}
