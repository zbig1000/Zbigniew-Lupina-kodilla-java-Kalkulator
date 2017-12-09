package com.kodilla.testing.calculator;

import com.kodilla.testing.calculator.Calculator;

public class TestingMain {

    public static void main (String[] args) {
        Calculator calc = new Calculator();

        if (calc.add(2.5d, 3.5d) !=  6) {
            System.out.println("Summing Error occured in class Calculator ");
            } else {
            System.out.println("Summing in class Calculator correct");
        }
        if (calc.substract(4.5d, 3.5d) !=  1) {
            System.out.println("Substract Error occured in class Calculator ");
        } else {
            System.out.println("Substracting in class Calculator correct");
        }


    }
}
