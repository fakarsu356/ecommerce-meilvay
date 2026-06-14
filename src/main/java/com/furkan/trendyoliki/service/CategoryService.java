package com.furkan.trendyoliki.service;

import java.util.List;


import com.furkan.trendyoliki.entity.Category;

public interface CategoryService {
List<Category> findAll();
Category findById(int id);
Category save(Category category);
void deleteById(int id); 
}
