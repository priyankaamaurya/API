package com.bus.bus.controller;

import com.bus.bus.entity.Bus;
import com.bus.bus.service.BusService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bus")
@RequiredArgsConstructor
public class BusController {

    BusService service;

    @Operation(summary = "object created of bus")
    @ApiResponse(responseCode = "201", description = "it will create object")
    @ApiResponse(responseCode = "400", description = "invalid data")

    @PostMapping
    public ResponseEntity<Bus> save(@RequestBody Bus bus){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.save(bus));
    }

    @GetMapping("/all")
    public List<Bus> findAllDoctor(){
        return service.findAll();
    }

    @GetMapping
    public ResponseEntity<Bus> findBusById(@PathVariable int id){
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(service.findById(id));
    }

    @PutMapping
    public ResponseEntity<Bus> updateBus(@PathVariable int id, @RequestBody Bus bus){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.updateBus(id, bus));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteBus(@PathVariable int id){
        service.deleteBus(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body("Bus deleted successfully");
    }

    @GetMapping("/find/{busName}")
    public ResponseEntity<List<Bus>> findByBusName(@PathVariable String busName){
        return ResponseEntity.ok(service.findByBusName(busName));
    }

}
