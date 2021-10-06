package com.example.shop.webrest;


import com.example.shop.dao.Order;
import com.example.shop.dto.Orderdto;
import com.example.shop.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shop")
public class OrderResource {

    private final OrderService orderService;

    public OrderResource(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("enterOrder")
    public ResponseEntity<Order> createORder(@RequestBody Orderdto orderdto){
        Order orderCreate = orderService.createOrder(orderdto);
        return ResponseEntity.ok().body(orderCreate);
    }

    @GetMapping("/order/{id}")
    public Optional<Order> retrieveOrder(@PathVariable int id){
        return orderService.findOrder(id);
    }

    @GetMapping("AllOrders")
    public ResponseEntity<List<Order>>AllOrders(){
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok().body(orders);
    }

    @DeleteMapping("/delROrder/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable int id){
        orderService.deleteOrder(id);
        return ResponseEntity.ok().body("Order deleted id : "+ id);
    }
}
