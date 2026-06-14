package com.furkan.trendyoliki.service;

import java.util.List;

import com.furkan.trendyoliki.entity.Product;

public interface ProductService {
List<Product> findAll();
Product findById(int id);
Product save(Product product);
void deleteById(int id); 
}
