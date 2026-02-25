package com.cart.cart.controller;

import com.cart.cart.entity.Cart;
import com.cart.cart.service.CartService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService service;

    @Operation(summary = "object created of cart")
    @ApiResponse(responseCode = "201", description = "it will create object")
    @ApiResponse(responseCode = "204", description = "invalid data")

    @PostMapping
    public ResponseEntity<Cart> save(@RequestBody Cart cart){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.saveCart(cart));
    }

    @GetMapping("/all")
    public List<Cart> findAllCart(){
        return service.findAll();
    }

    @GetMapping
    public ResponseEntity<Cart> findCartById(@PathVariable int id){
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(service.findById(id));
    }

    @PutMapping
    public ResponseEntity<Cart> updateCart(@PathVariable int id, @RequestBody Cart cart){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.updateCart(id, cart));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteCart(@PathVariable int id){
        service.deleteCart(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body("Cart deleted successfully");
    }
}
