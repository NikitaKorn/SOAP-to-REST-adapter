package ru.rest.service.service;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class CalculatorServiceTest {
    @Autowired
    CalculatorService calculatorService;

    @Test
    public void addOperationTest(){
        Assert.assertTrue(calculatorService.callAddOperation(12, 3) == 15);
    }

    @Test
    public void divideOperationTest(){
        Assert.assertTrue(calculatorService.callDivideOperation(12,6) == 2);
    }

    @Test
    public void multiplyTest(){
        Assert.assertTrue(calculatorService.callMultiplyOperation(3,5) == 15);
    }

    @Test
    public void subtractTest(){
        Assert.assertTrue(calculatorService.callSubtractOperation(12, 3) == 9);
    }
}