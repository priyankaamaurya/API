package com.odr.orders.controller;

import com.odr.orders.entity.Orders;
import com.odr.orders.service.OrdersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrdersController {

    private final OrdersService service;

    @Operation(summary = "create object of orders")
    @ApiResponse(responseCode = "201", description = "it will create object")
    @ApiResponse(responseCode = "400", description = "invalid data")

    @PostMapping
    public ResponseEntity<Orders> save(@RequestBody Orders orders){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.save(orders));
    }

    @GetMapping("/all")
    public List<Orders> findAllOrders(){
        return service.findAll();
    }

    @GetMapping
    public ResponseEntity<Orders> findOrdersById(@PathVariable int id){
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(service.findById(id));
    }

    @PutMapping
    public ResponseEntity<Orders> updateOrders(@PathVariable int id, @RequestBody Orders orders){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.updateOrders(id, orders));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteOrders(@PathVariable int id){
        service.deleteOrders(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body("Orders deleted successfully");
    }

    @GetMapping("/find{productName}")
    public ResponseEntity<List<Orders>> findByProductName(@PathVariable String productName){
        return ResponseEntity.ok(service.findByProductName(productName));
    }
}
