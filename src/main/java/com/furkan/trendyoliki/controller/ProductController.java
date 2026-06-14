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

import com.furkan.trendyoliki.entity.Product;
import com.furkan.trendyoliki.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> findAll(){
        return productService.findAll();
    }

    @GetMapping("/products/{productId}")
    public Product findById( @PathVariable int productId){


        return productService.findById(productId);
    }

    @PostMapping("/products")
    public Product save(@RequestBody Product product ){
        Product item =productService.save(product);
        return  item;
    }
    @PutMapping("/products")
    public Product update(@RequestBody Product product){
        Product item =productService.save(product);
        return item;

    }
    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable int id){

        productService.deleteById(id);
    }

}
