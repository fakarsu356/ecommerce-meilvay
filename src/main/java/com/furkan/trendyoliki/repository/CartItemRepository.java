package com.furkan.trendyoliki.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.furkan.trendyoliki.entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem,Integer>{
    
}
