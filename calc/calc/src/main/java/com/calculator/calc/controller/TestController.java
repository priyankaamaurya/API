package com.calculator.calc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    //Average of multiple numbers
    @GetMapping("/average")
    public double average(@RequestParam List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    //Average of multiple numbers
    @GetMapping("/avg")
    public int avg(@RequestParam List<Integer> n){
        int sum =0;
        for (int i:n){
            sum = sum+i;
        }
        return sum/n.size();
    }

}
