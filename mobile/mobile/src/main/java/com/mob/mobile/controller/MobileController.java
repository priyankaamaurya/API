package com.mob.mobile.controller;

import com.mob.mobile.entity.Mobile;
import com.mob.mobile.service.MobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mobile")
public class MobileController {

    @Autowired
    MobileService service;

    @PostMapping("/save")
    public Mobile save(@RequestBody Mobile mobile){
        return service.saveMobile(mobile);
    }

    @GetMapping("/all")
    public List<Mobile> findAllMobile(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Mobile findMobileById(@PathVariable int id){
        return service.findById(id);
    }

    @PutMapping("/update/{id}")
    public Mobile updateMobile(@PathVariable int id, @RequestBody Mobile mobile){
        return service.updateMobile(id, mobile);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteMobile(@PathVariable int id){
        service.deleteMobile(id);
        return "Mobile deleted successfully";
    }

}
