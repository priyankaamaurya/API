package com.cart.cart.service.impl;

import com.cart.cart.entity.Cart;
import com.cart.cart.repository.CartRepository;
import com.cart.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;

    @Override
    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    @Override
    public Cart findById(int id) {
        return cartRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cart not found "));
    }

    @Override
    public Cart updateCart(int id, Cart cart) {
        Cart cart1 = cartRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cart not found "));

        return cartRepository.save(cart);
    }

    @Override
    public void deleteCart(int id) {
        Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cart not found "));

        cartRepository.delete(cart);
    }


}
