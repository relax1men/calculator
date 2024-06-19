package com.example.calculator.controller;

import com.example.calculator.exception.NullException;
import com.example.calculator.service.CalculatorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String greetings() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("/plus")
    public String plus(@RequestParam(required = false) Double num1, @RequestParam(required = false) Double num2) {
        validateInput(num1, num2);
        var addition = calculatorService.plus(num1, num2);
        return num1 + "+" + num2 + " = " + addition;
    }

    @GetMapping("/minus")
    public String minus(@RequestParam(required = false) Double num1, @RequestParam(required = false) Double num2) {
        validateInput(num1, num2);
        var result = calculatorService.minus(num1, num2);
        return num1 + "-" + num2 + "=" + result;
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam(required = false) Double num1, @RequestParam(required = false) Double num2) {
        validateInput(num1, num2);
        var result = calculatorService.multiply(num1, num2);
        return num1 + "*" + num2 + "=" + result;
    }

    @GetMapping("/divide")
    public String divide(@RequestParam(required = false) Double num1, @RequestParam(required = false) Double num2) {
        validateInput(num1, num2);
        var result = calculatorService.divide(num1, num2);
        return num1 + "/" + num2 + "=" + result;
    }
    private void validateInput(Double num1, Double num2){
        if (num1 == null || num2 == null){
            throw new NullException("Нужно ввести оба числа");
        }
    }

}
