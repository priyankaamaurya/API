package com.odr.orders.controller;

import com.odr.orders.entity.Orders;
import com.odr.orders.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    OrdersService service;

    @PostMapping("/save")
    public Orders save(@RequestBody Orders orders){
        return service.save(orders);
    }

    @GetMapping("/all")
    public List<Orders> findAllOrders(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Orders findOrdersById(@PathVariable int id){
        return service.findById(id);
    }

    @PutMapping("/update/{id}")
    public Orders updateOrders(@PathVariable int id, @RequestBody Orders orders){
        return service.updateOrders(id, orders);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteOrders(@PathVariable int id){
        service.deleteOrders(id);
        return "Orders deleted successfully";
    }
}
