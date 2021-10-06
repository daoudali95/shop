package com.example.shop.dao;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Integer order_id;

    @Column(name = "user_id")
    private Integer user_id;

//    @Column(name = "product_id")
//    private Integer product_id;

    @CreatedDate
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "order_date")
    private LocalDateTime order_date = LocalDateTime.now();


    @Column(name = "quantity")
    private double product_quantity;

    @OneToMany(mappedBy="order", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Product> products;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

//    public Integer getProduct_id() {
//        return product_id;
//    }
//
//    public void setProduct_id(Integer product_id) {
//        this.product_id = product_id;
//    }

    public LocalDateTime getOrder_date() {
        return order_date;
    }

    public void setOrder_date(LocalDateTime order_date) {
        this.order_date = order_date;
    }

    public double getProduct_quantity() {
        return product_quantity;
    }

    public void setProduct_quantity(double product_quantity) {
        this.product_quantity = product_quantity;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}