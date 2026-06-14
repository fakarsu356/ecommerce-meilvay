package com.furkan.trendyoliki.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.furkan.trendyoliki.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    
}
