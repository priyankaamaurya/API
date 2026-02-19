package com.calculator.calc.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TestController {

    //Add two numbers
    @GetMapping("/add")
    public int add(@RequestParam int a, @RequestParam int b){
        return a + b;
    }

    //Multiply two numbers
    @GetMapping("/multiply")
    public int multiply(@RequestParam int a, @RequestParam int b){
        return a*b;
    }

    //Average of given numbers
    @GetMapping("/average")
    public double average(@RequestParam List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    @GetMapping("/avg")
    public int avg(@RequestParam List<Integer> n, HttpServletResponse resp){
        Cookie cookie = new Cookie("a", "10");
        Cookie cookie1 = new Cookie("b", "10");
        Cookie cookie2 = new Cookie("c", "10");
        Cookie cookie3 = new Cookie("d", "10");
        resp.addCookie(cookie);
        resp.addCookie(cookie1);
        resp.addCookie(cookie2);
        resp.addCookie(cookie3);

        int sum =0;
        for (int i:n){
            sum = sum+i;
        }
        return sum/n.size();
    }

    @GetMapping("/cookie")
    public String cookie(@CookieValue String a){
        return a;
    }

    @GetMapping("/{num}/pr")
    public int pv(@RequestParam int id, @PathVariable int num){
        return id+num;
    }

}
