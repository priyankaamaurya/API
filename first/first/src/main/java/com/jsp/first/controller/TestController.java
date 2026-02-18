package com.jsp.first.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@Controller
@RestController
public class TestController {


//    @RequestMapping("/hlo")
    @GetMapping(value  = "/hlo")
    public String hello(HttpServletRequest req, HttpServletResponse resp) {

        System.out.println("/hlo");

//        System.out.println(req);
//        System.out.println(resp);

        // logic
        return "hlo.html";
    }

    @PostMapping("/save")
    public Person save(@RequestBody Person person){
        return person;
    }

    @GetMapping("/find")
    public String find(@RequestParam int id, @RequestParam("name") String name){
        return id + name;
    }
}
