package com.practice.mortgagecalculator;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @PostMapping("/calculate")
    public String calculate(@RequestParam String homePrice, @RequestParam String interestRate, @RequestParam String tax, @RequestParam String loanLength, @RequestParam String insuranceCost, @RequestParam String downPayment ) {

        Mortgage m = new Mortgage(homePrice, interestRate, tax, loanLength, insuranceCost, downPayment);

        return String.valueOf(m.calculatePayment());

    }

}
