package com.furkan.trendyoliki.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.furkan.trendyoliki.entity.Orders;

public interface OrderRepository extends  JpaRepository<Orders,Integer> {
    
}
