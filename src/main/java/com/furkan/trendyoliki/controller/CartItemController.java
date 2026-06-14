package com.furkan.trendyoliki.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furkan.trendyoliki.entity.CartItem;
import com.furkan.trendyoliki.service.CartItemService;

@RestController
@RequestMapping("/api")
public class CartItemController {

    private CartItemService cartItemService;

    public CartItemController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @GetMapping("/cartItems")
    public List<CartItem> findAll(){
        return cartItemService.findAll();
    }

    @GetMapping("/cartItems/{cartItemId}")
    public CartItem findById( @PathVariable int cartItemId){


        return cartItemService.findById(cartItemId);
    }

    @PostMapping("/cartItems")
    public CartItem save(@RequestBody CartItem cartItem ){
        CartItem item =cartItemService.save(cartItem);
        return  item;
    }
    @PutMapping("/cartItems")
    public CartItem update(@RequestBody CartItem cartItem){
        CartItem item =cartItemService.save(cartItem);
        return item;

    }
    @DeleteMapping("/cartItems/{id}")
    public void delete(@PathVariable int id){

        cartItemService.deleteById(id);
    }

}
