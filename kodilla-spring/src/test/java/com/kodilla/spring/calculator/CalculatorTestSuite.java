package com.kodilla.spring.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {

    @Test
    public void testCalculations() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);

        //When
        double addResult = calculator.add(0.1, 0.2);
        double subResult = calculator.sub(0.1, 0.2);
        double mulResult = calculator.mul(0.1, 0.2);
        double divResult = calculator.div(0.1, 0.2);

        //Then
        Assert.assertEquals(0.3, addResult, 0.0001d);
        Assert.assertEquals(-0.1, subResult, 0.0001d);
        Assert.assertEquals(0.02, mulResult, 0.0001d);
        Assert.assertEquals(0.5, divResult, 0.0001d);

    }
}
