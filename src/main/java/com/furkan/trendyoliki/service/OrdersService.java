package com.furkan.trendyoliki.service;

import java.util.List;

import com.furkan.trendyoliki.entity.Orders;

public interface OrdersService {
List<Orders> findAll();
Orders findById(int id);
Orders save(Orders order);
void deleteById(int id); 
}
