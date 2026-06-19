package com.furkan.trendyoliki.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furkan.trendyoliki.entity.CartItem;
import com.furkan.trendyoliki.entity.Product;
import com.furkan.trendyoliki.entity.User;
import com.furkan.trendyoliki.repository.ProductRepository;
import com.furkan.trendyoliki.repository.UserRepository;
import com.furkan.trendyoliki.service.CartItemService;

@RestController
@RequestMapping("/api")
public class CartItemController {

    // 1. DOKUNUŞ: Değişkenlere 'final' eklendi (Güvenlik ve Clean Code için)
    private final CartItemService cartItemService;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    public CartItemController(CartItemService cartItemService, UserRepository userRepository,ProductRepository productRepository) {
        this.cartItemService = cartItemService;
        this.userRepository = userRepository;
        this.productRepository=productRepository;
    }

    @GetMapping("/cartItems")
    public List<CartItem> findAll(Authentication authentication) {
        // Harika güvenlik yaklaşımı: O anki kullanıcıyı bul ve sadece onun sepetini getir!
        String username = authentication.getName();
        User customer = userRepository.findByUsername(username);
        return cartItemService.findByCustomerId(customer.getId());
    }

    @GetMapping("/cartItems/{cartItemId}")
    public CartItem findById(@PathVariable int cartItemId){
        // 2. DOKUNUŞ: findByCustomerId yerine findById çağrıldı!
        return cartItemService.findById(cartItemId);
    }

  @PostMapping("/cartItems")
public CartItem save(@RequestBody CartItem cartItem, 
                     Authentication authentication) {
    
    // Customer'ı bul ve set et
    String username = authentication.getName();
    User customer = userRepository.findByUsername(username);
    cartItem.setCustomer(customer);
    
    // Product'ı DB'den çek ve set et
    Product product = productRepository.findById(
        cartItem.getProduct().getId()
    ).orElseThrow();
    cartItem.setProduct(product);
    
    return cartItemService.save(cartItem);
}

    @PutMapping("/cartItems")
    public CartItem update(@RequestBody CartItem cartItem){
        CartItem item = cartItemService.save(cartItem);
        return item;
    }

    @DeleteMapping("/cartItems/{id}")
    public void delete(@PathVariable int id){
        cartItemService.deleteById(id);
    }

}