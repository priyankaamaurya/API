package com.odr.orders.service;

import com.odr.orders.entity.Orders;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface OrdersService {
    Orders save(Orders orders);

    List<Orders> findAll();

    Orders findById(int id);

    Orders updateOrders(int id, Orders orders);

    void deleteOrders(int id);

    List<Orders> findByProductName(String productName);
}
