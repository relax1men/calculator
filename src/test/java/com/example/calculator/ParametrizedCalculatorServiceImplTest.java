package com.example.calculator;

import com.example.calculator.exception.DivideException;
import com.example.calculator.service.CalculatorServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ParametrizedCalculatorServiceImplTest {
    private CalculatorServiceImpl calculator;

    @BeforeEach
    public void calculatorSetUp() {
        calculator = new CalculatorServiceImpl();
    }

    @ParameterizedTest
    @MethodSource("numbersForPlus")
    public void shouldPlusNumbers(double num1, double num2, double expected) {
        var result = calculator.plus(num1, num2);

        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("numbersForMinus")
    public void shouldMinusNumbers(double num1, double num2, double expected) {
        var result = calculator.minus(num1, num2);

        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("numbersForMultiply")
    public void shouldMultiplyNumbers(double num1, double num2, double expected) {
        var result = calculator.multiply(num1, num2);

        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("numbersForDivide")
    public void shouldDivideNumbers(double num1, double num2, double expected) {
        var result = calculator.divide(num1, num2);

        Assertions.assertEquals(expected, result);
    }

    static Stream<Arguments> numbersForPlus() {
        return Stream.of(
                Arguments.of(5, 5.5, 10.5),
                Arguments.of(5, -7, -2)
        );
    }

    static Stream<Arguments> numbersForMinus() {
        return Stream.of(
                Arguments.of(5, 5.5, -0.5),
                Arguments.of(5, -7, 12)
        );
    }
    static Stream<Arguments> numbersForMultiply() {
        return Stream.of(
                Arguments.of(5, 5, 25),
                Arguments.of(5, -7, -35)
        );
    }    static Stream<Arguments> numbersForDivide() {
        return Stream.of(
                Arguments.of(5, 5, 1),
                Arguments.of(5, -1, -5)
        );
    }

}
