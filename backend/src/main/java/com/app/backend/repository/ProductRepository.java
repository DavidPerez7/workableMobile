package com.app.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.backend.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByName(String name);
    Boolean existsByName(String name);
    Boolean existsByPrice(Double price);
    Boolean existsBySubcategoryId(Long subcategoryId);
    Boolean existsByCategoryId(Long categoryId);
    Boolean existsByStock(Integer stock);
}
