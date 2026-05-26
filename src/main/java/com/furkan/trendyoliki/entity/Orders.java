package com.furkan.trendyoliki.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="orders")
public class Orders {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name="customer_id")
    private User customer;
    @Column(name="totalPrice")
    private Double totalPrice;
    @Column(name="orderDate")
    private LocalDateTime  orderDate;
    public Orders(Integer id, User customer, Double totalPrice, LocalDateTime orderDate) {
        this.id = id;
        this.customer = customer;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public User getCustomer() {
        return customer;
    }
    public void setCustomer(User customer) {
        this.customer = customer;
    }
    public Double getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public LocalDateTime getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

}
