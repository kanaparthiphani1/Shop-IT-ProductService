package com.example.sample.services.products;

import com.example.sample.DTO.CreateProductDTO;
import com.example.sample.exception.ProductNotFoundException;
import com.example.sample.models.Category;
import com.example.sample.models.Product;
import com.example.sample.projections.ProductWithCategory;
import com.example.sample.repository.CategoryRepository;
import com.example.sample.repository.ProductRepository;
import com.example.sample.services.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class RealProductService implements ProductService{

    private ProductRepository productRepository;
    private CategoryService categoryService;

    @Autowired
    public RealProductService(ProductRepository productRepository,CategoryService categoryService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    @Override
    public ProductWithCategory getProductById(Long id) {
        return productRepository.getProductWithCategoryById(id);
    }

    @Override
    public Page<Product> getAllProducts(int pageNum,int pageSize, String dir) {
        return productRepository.findAll(PageRequest.of(pageNum,pageSize,dir.equalsIgnoreCase("asc")?Sort.by("price").ascending() :
                Sort.by("price").descending()));
    }

    @Override
    public Product createProduct(CreateProductDTO product) {
        Product product1 = new Product(product);
//        if(product1.getCategory().getId()!=null){
//            Category category = categoryService.getCategoryById(product1.getCategory().getId());
//            product1.setCategory(category);
//        }
        return productRepository.save(product1);
    }

    @Override
    public Product replaceProduct(Product product) throws ProductNotFoundException{
        Optional<Product> curOpt = productRepository.findById(product.getId());
        if(curOpt.isEmpty()){
            throw new ProductNotFoundException("Product Not Found",product.getId());
        }

        return productRepository.save(product);
    }
}
