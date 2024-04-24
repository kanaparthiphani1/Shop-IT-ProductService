package com.example.sample.services;

import com.example.sample.DTO.FakeStoreProductDTO;
import com.example.sample.models.Category;
import com.example.sample.models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class FakeStoreProductService implements ProductService{


    private RestTemplate rt;

    public FakeStoreProductService(RestTemplate rt){
        this.rt = rt;
    }

    private Product convertToProduct(FakeStoreProductDTO dto){
        Product product = new Product();
        product.setId(dto.getId());
        product.setTitle(dto.getTitle());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setImageUrl(dto.getImage());

        Category category = new Category();
        category.setTitle(dto.getTitle());
        product.setCategory(category);
        return product;
    }

    @Override
    public Product getProductById(Long id) {
        ResponseEntity<FakeStoreProductDTO> prod = this.rt.getForEntity(
                "https://fakestoreapi.com/products/"+id, FakeStoreProductDTO.class);

        if(prod.getBody()==null){
            return null;
        }

        return convertToProduct(prod.getBody());
    }

    @Override
    public List<Product> getAllProducts() {
        ResponseEntity<FakeStoreProductDTO[]> prods = this.rt.getForEntity("https://fakestoreapi.com/products",FakeStoreProductDTO[].class);
        if(prods.getBody()==null){
            return null;
        }

        List<Product> lis = Arrays.stream(prods.getBody())
                                .map(prod-> convertToProduct(prod))
                                .toList();
        return lis;

    }
}
