package com.furkan.trendyoliki.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
    @GetMapping("/products/search")
    public List<Product> searchByName(@RequestParam String name) {
       return  productService.searchByName(name);
    }
      @GetMapping("/products/category/{categoryId}")
      public  List<Product> findByCategory(@PathVariable Integer categoryId){
        return productService.findByCategory(categoryId);
      }
      @GetMapping("/products/filter")
      public List<Product> filter(@RequestParam  Double min,@RequestParam  Double max) {
        return   productService.findByPriceRange(min, max);
      }
      
      @PostMapping("/products/{id}/image")
public Product uploadImage(@PathVariable int id,@RequestParam("image") MultipartFile file) throws IOException {
    
    // 1. Klasör oluştur
    Path uploadPath = Paths.get("uploads/images");
    Files.createDirectories(uploadPath);
    
    // 2. Dosyayı kaydet
    Path filePath = uploadPath.resolve(file.getOriginalFilename());
    Files.copy(file.getInputStream(), filePath);
    
    // 3. Ürünü bul
    Product product = productService.findById(id);
    
    // 4. imageUrl'i set et
    product.setImage_url    ("uploads/images/" + file.getOriginalFilename());
    
    // 5. Kaydet ve döndür
    return productService.save(product);
}

}
