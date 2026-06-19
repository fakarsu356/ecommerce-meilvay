package com.furkan.trendyoliki.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.furkan.trendyoliki.entity.CartItem;
import com.furkan.trendyoliki.repository.CartItemRepository;

@Service
public class CartItemImpl implements CartItemService {
    
    // 1. DOKUNUŞ: Güvenlik için 'final' eklendi
    private final CartItemRepository cartItemRepository;

    public CartItemImpl(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public List<CartItem> findAll() {
       return cartItemRepository.findAll();
    }

    // 2. DOKUNUŞ: Senin yazdığın kod buydu. Kendi ID'sine göre bulduğu için adını findById yaptık.
    @Override
    public CartItem findById(int id) {
        Optional<CartItem> result = cartItemRepository.findById(id);

        CartItem cartItem = null;

        if (result.isPresent()) {
            cartItem = result.get();
        }
        else {
            // Employee yorumu silindi, şık bir Türkçe hata mesajı eklendi.
            throw new RuntimeException("Sepette bu ID'ye sahip kayıt bulunamadı: " + id);
        }

        return cartItem;
    }

    // 3. DOKUNUŞ: İşte müşterinin (Customer) tüm sepetini getirecek asıl metot (LİSTE DÖNER)
    @Override
    public List<CartItem> findByCustomerId(int customerId) {
        return cartItemRepository.findByCustomerId(customerId);
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

