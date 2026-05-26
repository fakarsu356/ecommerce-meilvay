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
    @Table(name="cart_items")
    public class CartItem {
        
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

// Veritabanında → customer_id tutacak (Integer)
//Java'da → User customer objesi tutacak
//JPA ikisi arasında köprü kuruyor. Veritabanına kaydederken User objesinin id'sini alıp customer_id olarak yazıyor. Okurken customer_id'yi alıp users tablosundan User objesini getiriyor. 
    @ManyToOne
    @JoinColumn(name="customer_id")
    private User customer;
    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    @Column(name="quantity")
    private Integer quantity;
    }
