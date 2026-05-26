package com.furkan.trendyoliki.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="products")
public class Product {
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
     private Integer id;

     @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="price")
    private Double price;

    @ManyToOne 
    @JoinColumn(name="category_id")
    private Category category;
    
    @Column(name="stock")
    private int stock;

    @ManyToOne 
    @JoinColumn(name="seller_id") 
    private User seller;
    
    @Column(name="image_url")
    private String image_url;


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public Product(Integer id, String name,String description, Double price, Category category, int stock, User seller_id,
            String image_url) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.stock = stock;
        this.seller = seller_id;
        this.image_url = image_url;
        this.description=description;
    }
    public User getSeller() {
        return seller;
    }
    public void setSeller_id(User seller_id) {
        this.seller = seller_id;
    }
    public String getImage_url() {
        return image_url;
    }
    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
    public Product() {
    }
}
