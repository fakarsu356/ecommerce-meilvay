package com.furkan.trendyoliki.service;

import java.util.List;

import com.furkan.trendyoliki.entity.CartItem;

public interface CartItemService {
List<CartItem> findAll();   
CartItem save(CartItem cartItem);
void deleteById(int id); 
List<CartItem> findByCustomerId(int id);
CartItem findById(int id);
}
