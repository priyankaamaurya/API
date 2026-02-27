package com.odr.orders.service.impl;

import com.odr.orders.entity.Orders;
import com.odr.orders.exception.OrdersException;
import com.odr.orders.repository.OrdersRepository;
import com.odr.orders.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    OrdersRepository ordersRepository;

    @Override
    public Orders save(Orders orders) {
        if (ordersRepository.existsByProductName(orders.getProductName()))
            throw new OrdersException("product name already exist");
        return ordersRepository.save(orders);
    }

    @Override
    public List<Orders> findAll() {
        return ordersRepository.findAll();
    }

    @Override
    public Orders findById(int id) {
        return ordersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found "));
    }

    @Override
    public Orders updateOrders(int id, Orders orders) {
        Orders orders1 = ordersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found "));

        return ordersRepository.save(orders);
    }

    @Override
    public void deleteOrders(int id) {
        Orders orders = ordersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found "));

        ordersRepository.delete(orders);
    }

    @Override
    public List<Orders> findByProductName(String productName) {
        return ordersRepository.findByProductName(productName);
    }


}
