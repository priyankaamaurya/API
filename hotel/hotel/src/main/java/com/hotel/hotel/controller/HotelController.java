package com.hotel.hotel.controller;

import com.hotel.hotel.entity.Hotel;
import com.hotel.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    HotelService service;

    @PostMapping("/save")
    public Hotel save(@RequestBody Hotel hotel){
        return service.saveHotel(hotel);
    }

    @GetMapping("/all")
    public List<Hotel> findAllHotel(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Hotel findById(@PathVariable int id){
        return service.findById(id);
    }

    @PutMapping("/update/{id}")
    public Hotel updateHotel(@PathVariable int id, @RequestBody Hotel hotel){
        return service.updatePerson(id, hotel);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteHotel(@PathVariable int id){
        service.deleteHotel(id);
        return "Hotel deleted successfully";
    }
}
