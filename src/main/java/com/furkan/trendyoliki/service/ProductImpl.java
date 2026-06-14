package com.furkan.trendyoliki.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.furkan.trendyoliki.entity.Product;
import com.furkan.trendyoliki.repository.ProductRepository;


@Service
public class ProductImpl implements  ProductService {
    
    private ProductRepository productRepository;

    public ProductImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
       return productRepository.findAll();
    }

    @Override
    public Product findById(int id) {
     Optional<Product> result = productRepository.findById(id);

        Product product = null;

        if (result.isPresent()) {
            product = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find product id - " + id);
        }

        return product;
        
    }

    @Override
    public Product save(Product product) {
    return productRepository.save(product);
    }

    @Override
    public void deleteById(int id) {
      productRepository.deleteById(id);
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

