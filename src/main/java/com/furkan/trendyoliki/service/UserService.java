package com.furkan.trendyoliki.service;

import java.util.List;

import com.furkan.trendyoliki.entity.User;

public interface UserService {
List<User> findAll();
User findById(int id);
User save(User user);
void deleteById(int id);
    
}
