package com.cart.cart.controller;

import com.cart.cart.entity.Cart;
import com.cart.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(("/cart"))
public class CartController {

    @Autowired
    CartService service;


    @PostMapping("/save")
    public Cart save(@RequestBody Cart cart){
        return service.saveCart(cart);
    }

    @GetMapping("/all")
    public List<Cart> findAllCart(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Cart findCartById(@PathVariable int id){
        return service.findById(id);
    }

    @PutMapping("/update/{id}")
    public Cart updateCart(@PathVariable int id, @RequestBody Cart cart){
        return service.updateCart(id, cart);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCart(@PathVariable int id){
        service.deleteCart(id);
        return "Cart deleted successfully";
    }
}
