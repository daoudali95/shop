package com.example.shop.service;

import com.example.shop.dao.Order;
import com.example.shop.dao.Product;
import com.example.shop.dto.Orderdto;
import com.example.shop.repo.OrderRepository;
import com.example.shop.repo.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public Order createOrder(Orderdto orderdto){
        Order order1 = new Order();
        Set<Product> productSet = new HashSet<>();

            order1.setUser_id(orderdto.getUser_id());
            order1.setOrder_date(orderdto.getOrder_date());

            for (String product : orderdto.getProducts()) {
                Optional<Product> productRes = productRepository.findByProductName(product);
                if (productRes.isPresent())
                    productSet.add(productRes.get());
            }
            order1.setProducts(productSet);
        return orderRepository.save(order1);
    }
    public Optional<Order> findOrder(Integer id){return orderRepository.findById(id);}

    public List<Order> getAllOrders(){return orderRepository.findAll();}

    public void deleteOrder(int id){
        orderRepository.deleteById(id);
    }

}
