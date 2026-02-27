package com.mob.mobile.controller;

import com.mob.mobile.entity.Mobile;
import com.mob.mobile.service.MobileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mobile")
@RequiredArgsConstructor
public class MobileController {

    private final MobileService service;

    @Operation(summary = "created object of mobile")
    @ApiResponse(responseCode = "201", description = "it will create object")
    @ApiResponse(responseCode = "400", description = "invalid data")

    @PostMapping
    public ResponseEntity<Mobile> save(@RequestBody Mobile mobile){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.saveMobile(mobile));
    }

    @GetMapping("/all")
    public List<Mobile> findAllMobile(){
        return service.findAll();
    }

    @GetMapping
    public ResponseEntity<Mobile> findMobileById(@PathVariable int id){
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(service.findById(id));
    }

    @PutMapping
    public ResponseEntity<Mobile> updateMobile(@PathVariable int id, @RequestBody Mobile mobile){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.updateMobile(id, mobile));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteMobile(@PathVariable int id){
        service.deleteMobile(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body("Mobile deleted successfully");
    }

    @GetMapping("/find/{brand}")
    public ResponseEntity<List<Mobile>> findByBrand(@PathVariable String brand){
        return ResponseEntity.ok(service.findByBrand(brand));
    }

}
