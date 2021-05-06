package com.practice.mortgagecalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

// TODO: 5/3/2021 do controller and get values from ui  
public class MortgageCalculatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(MortgageCalculatorApplication.class, args);
    }


    @GetMapping("/hello")
    public String sayHello(@RequestParam(value  = "myName", defaultValue = "World" )String name){
        return String.format("Hello %s", name);
    }


}
