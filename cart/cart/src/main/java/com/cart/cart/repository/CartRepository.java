package com.cart.cart.repository;

import com.cart.cart.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

    List<Cart> findByCartItem(String cartItem);

    boolean existsByCartItem(String cartItem);
}
