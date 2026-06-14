package com.furkan.trendyoliki.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.furkan.trendyoliki.entity.User;
import com.furkan.trendyoliki.repository.UserRepository;


@Service
public class UserImpl implements  UserService {
    
    private UserRepository userRepository;

    public UserImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
       return userRepository.findAll();
    }

    @Override
    public User findById(int id) {
     Optional<User> result = userRepository.findById(id);

        User user = null;

        if (result.isPresent()) {
            user = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find the  user id - " + id);
        }

        return user;
        
    }

    @Override
    public User save(User user) {
    return userRepository.save(user);
    }

    @Override
    public void deleteById(int id) {
      userRepository.deleteById(id);
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

