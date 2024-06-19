package com.example.calculator;

import com.example.calculator.exception.DivideException;
import com.example.calculator.service.CalculatorServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorServiceImplTest {
    private CalculatorServiceImpl calculator;

    @BeforeEach
    public void calculatorSetUp() {
        calculator = new CalculatorServiceImpl();
    }

    @Test
    public void shouldPlusToPositiveNumber() {
        var expected = 10.5;

        var result = calculator.plus(5, 5.5);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void shouldPlusNegativeNumber() {
        var expected = -4;

        var result = calculator.plus(3, -7);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void shouldMinusPositiveNumber() {
        var expected = 20;

        var result = calculator.minus(50, 30);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void shouldMinusNegativeNumber() {
        var expected = 66;

        var result = calculator.minus(21, -45);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void shouldMultiplyPositiveNumber() {
        var expected = 30;

        var result = calculator.multiply(10, 3);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void shouldMultiplyNegativeNumber() {
        var expected = 0;

        var result = calculator.multiply(4, 0);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void shouldDividePositiveNumber() {

        var expected = 30;

        var result = calculator.divide(120, 4);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void shouldDivideNegativeNumber() {

        var expected = -8;

        var result = calculator.divide(-40, 5);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void shouldDivideZeroNumber() {
        Assertions.assertThrows(DivideException.class, () -> calculator.divide(40, 0));
    }
}
