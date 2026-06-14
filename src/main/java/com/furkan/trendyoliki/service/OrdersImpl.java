package com.furkan.trendyoliki.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.furkan.trendyoliki.entity.Orders;
import com.furkan.trendyoliki.repository.OrderRepository;


@Service
public class OrdersImpl implements  OrdersService {
    
    private OrderRepository orderRepository;

    public OrdersImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Orders> findAll() {
       return orderRepository.findAll();
    }

    @Override
    public Orders findById(int id) {
     Optional<Orders> result = orderRepository.findById(id);

        Orders order = null;

        if (result.isPresent()) {
            order = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find product id - " + id);
        }

        return order;
        
    }

    @Override
    public Orders save(Orders order) {
    return orderRepository.save(order);
    }

    @Override
    public void deleteById(int id) {
      orderRepository.deleteById(id);
    }
    
}
// Fiyat 0'dan büyük olmalı
// Stok 0'dan büyük olmalı
//- Sadece SELLER ürün ekleyebilir

//OrdersService:

//- Stok yeterliyse sipariş ver
//- Sipariş verilince stok azalt
//- Kupon geçerliyse indirim uygula

//UserService:

//- Email daha önce kayıtlı mı?
//- Şifre en az 6 karakter mi?
//- Şifreyi bcrypt ile şifrele

//CartService:

//- Aynı ürün sepette varsa miktarı artır
//- Stok yoksa sepete ekleme

