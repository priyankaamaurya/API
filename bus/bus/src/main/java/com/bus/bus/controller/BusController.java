package com.bus.bus.controller;

import com.bus.bus.entity.Bus;
import com.bus.bus.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bus")
public class BusController {

    @Autowired
    BusService service;

    @PostMapping("/save")
    public Bus save(@RequestBody Bus bus){
        return service.save(bus);
    }

    @GetMapping("/all")
    public List<Bus> findAllDoctor(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Bus findBusById(@PathVariable int id){
        return service.findById(id);
    }

    @PutMapping("/update/{id}")
    public Bus updateBus(@PathVariable int id, @RequestBody Bus bus){
        return service.updateBus(id, bus);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBus(@PathVariable int id){
        service.deleteBus(id);
        return "Bus deleted successfully";
    }
}
