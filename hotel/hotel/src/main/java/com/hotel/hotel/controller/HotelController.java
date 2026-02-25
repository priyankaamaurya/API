package com.hotel.hotel.controller;

import com.hotel.hotel.entity.Hotel;
import com.hotel.hotel.service.HotelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
@RequiredArgsConstructor
public class HotelController {

    private final HotelService service;

    @Operation(summary = "object created of hotel")
    @ApiResponse(responseCode = "201", description = "it will create object")
    @ApiResponse(responseCode = "204", description = "invalid data")

    @PostMapping
    public ResponseEntity<Hotel> save(@RequestBody Hotel hotel){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.saveHotel(hotel));
    }

    @GetMapping("/all")
    public List<Hotel> findAllHotel(){
        return service.findAll();
    }

    @GetMapping
    public ResponseEntity<Hotel> findById(@PathVariable int id){
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(service.findById(id));
    }

    @PutMapping
    public ResponseEntity<Hotel> updateHotel(@PathVariable int id, @RequestBody Hotel hotel){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.updatePerson(id, hotel));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteHotel(@PathVariable int id){
        service.deleteHotel(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body("Hotel deleted successfully");
    }
}
