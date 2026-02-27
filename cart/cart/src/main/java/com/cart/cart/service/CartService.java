package com.cart.cart.service;

import com.cart.cart.entity.Cart;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface CartService {
    Cart saveCart(Cart cart);

    List<Cart> findAll();

    Cart findById(int id);

    Cart updateCart(int id, Cart cart);

    void deleteCart(int id);

     List<Cart> findByCartItem(String cartItem);
}
