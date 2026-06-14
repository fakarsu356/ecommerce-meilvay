package com.furkan.trendyoliki.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.furkan.trendyoliki.entity.CartItem;
import com.furkan.trendyoliki.repository.CartItemRepository;


@Service
public class CartItemImpl implements  CartItemService {
    
    private CartItemRepository cartItemRepository;

    public CartItemImpl(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public List<CartItem> findAll() {
       return cartItemRepository.findAll();
    }

    @Override
    public CartItem findById(int id) {
     Optional<CartItem> result = cartItemRepository.findById(id);

        CartItem cartItem = null;

        if (result.isPresent()) {
            cartItem = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find cart item id - " + id);
        }

        return cartItem;
        
    }

    @Override
    public CartItem save(CartItem cartItem) {
    return cartItemRepository.save(cartItem);
    }

    @Override
    public void deleteById(int id) {
      cartItemRepository.deleteById(id);
    }
    
}
// Fiyat 0'dan büyük olmalı
// Stok 0'dan büyük olmalı
//- Sadece SELLER ürün ekleyebilir

//OrderService:

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

