package com.app.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.backend.models.Category;
import com.app.backend.models.Product;
import com.app.backend.models.Subcategory;
import com.app.backend.repository.ProductRepository;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SubCategoryService subCategoryService;

    @Autowired
    private CategoryService categoryService;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    public List<Product> findByCategoryId(Long categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }

    public List<Product> findBySubcategoryId(Long subcategoryId) {
        return productRepository.findBySubcategoryId(subcategoryId);
    }

    public Product create(Product request) {
        Subcategory subcategory = subCategoryService.findById(request.getSubcategory().getId());
        Category category = categoryService.findById(request.getCategory().getId());
        request.setSubcategory(subcategory);
        request.setCategory(category);
        return productRepository.save(request);
    }

    public Product update(Long id, Product request) {
        Product product = findById(id);
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setActive(request.getActive());
        Category category = categoryService.findById(request.getCategory().getId());
        Subcategory subcategory = subCategoryService.findById(request.getSubcategory().getId());
        product.setSubcategory(subcategory);
        product.setCategory(category);
        return productRepository.save(product);
    }

    public void delete(Long id) {
        Product product = findById(id);
        productRepository.delete(product);
    }
}
