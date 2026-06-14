package com.furkan.trendyoliki.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.furkan.trendyoliki.entity.Category;
import com.furkan.trendyoliki.repository.CategoryRepository;


@Service
public class CategoryImpl implements  CategoryService {
    
    private CategoryRepository categoryRepository;

    public CategoryImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
       return categoryRepository.findAll();
    }

    @Override
    public Category findById(int id) {
     Optional<Category> result = categoryRepository.findById(id);

        Category category = null;

        if (result.isPresent()) {
            category = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find category id - " + id);
        }

        return category;
        
    }

    @Override
    public Category save(Category category) {
    return categoryRepository.save(category);
    }

    @Override
    public void deleteById(int id) {
      categoryRepository.deleteById(id);
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

