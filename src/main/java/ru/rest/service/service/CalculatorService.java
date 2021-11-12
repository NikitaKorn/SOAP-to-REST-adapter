package ru.rest.service.service;

public interface CalculatorService {

    int callAddOperation(int firstNumber, int secondNumber);

    int callDivideOperation(int firstNumber, int secondNumber);

    int callMultiplyOperation(int firstNumber, int secondNumber);

    int callSubtractOperation(int firstNumber, int secondNumber);
}
