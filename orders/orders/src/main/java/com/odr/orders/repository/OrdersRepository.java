package com.odr.orders.repository;

import com.odr.orders.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {

    List<Orders> findByProductName(String productName);

    boolean existsByProductName(String productName);
}
