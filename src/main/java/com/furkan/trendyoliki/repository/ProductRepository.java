package com.furkan.trendyoliki.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.furkan.trendyoliki.entity.Product;


public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findByName(String name);
    List<Product> findByCategoryId(Integer id);
    List<Product> findByPriceBetween(Double minPrice, Double maxPrice);
}
