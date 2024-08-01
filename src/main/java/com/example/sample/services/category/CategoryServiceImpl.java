package com.example.sample.services.category;

import com.example.sample.DTO.CategoryProdDTO;
import com.example.sample.models.Category;
import com.example.sample.models.Product;
import com.example.sample.repository.CategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    private  final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Page<Category> getCategories(int pageNumber, int pageSize, String order) {
        return categoryRepository.findAll(PageRequest.of(pageNumber,pageSize,order.equalsIgnoreCase("asc")? Sort.by("title").ascending() :
                Sort.by("title").descending()));
    }

    @Override
    public Category getCategoryById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.orElse(null);
    }

    @Override
    public CategoryProdDTO getCompleteCategoryById(Long id) {
        Optional<Category> catOpt = categoryRepository.findById(id);
        CategoryProdDTO prodDTO = new CategoryProdDTO();
        if(catOpt.isEmpty()){
            return prodDTO;
        }
        prodDTO.setId(catOpt.get().getId());
        prodDTO.setTitle(catOpt.get().getTitle());
        List<Product> products = catOpt.get().getProducts();
//        System.out.println("Products : "+products.t);
        prodDTO.setProducts(products);
        return prodDTO;
    }
}
