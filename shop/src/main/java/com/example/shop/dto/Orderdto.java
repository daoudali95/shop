package com.example.shop.dto;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

public class Orderdto {

    private Integer user_id;

//    private String productName;

    List<String> products;

    @CreatedDate
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDateTime order_date = LocalDateTime.now();

    private double product_quantity;

    public Orderdto() {
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public List<String> getProducts() {
        return products;
    }

    public void setProducts(List<String> products) {
        this.products = products;
    }

//    public String getProductName() {
//        return productName;
//    }
//
//    public void setProductName(String productName) {
//        this.productName = productName;
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
}
