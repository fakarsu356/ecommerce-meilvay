package com.furkan.trendyoliki.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.furkan.trendyoliki.entity.Category;

public interface CategoryRepository extends  JpaRepository<Category,Integer> {
    
}
