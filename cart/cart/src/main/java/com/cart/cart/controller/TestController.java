package com.cart.cart.controller;

import com.cart.cart.entity.Cart;

public class TestController {

    public static void main(String[] args) {

        Cart c = new Cart();
        c.setCartItem("Laptop");

        Cart cart = new Cart(12, "Television", 85000.00);

        System.out.println(c.getCartItem());
        System.out.println(cart.getPrice());
    }
}
