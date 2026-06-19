package com.furkan.trendyoliki.repository;

import java.util.List; // Liste kullanacağımız için bunu import ettik

import org.springframework.data.jpa.repository.JpaRepository;

import com.furkan.trendyoliki.entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
    
    // Müşterinin (Customer) ID'sine göre tüm sepet LİSTESİNİ getirir
    List<CartItem> findByCustomerId(int customerId);
}