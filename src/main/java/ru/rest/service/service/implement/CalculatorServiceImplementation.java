package ru.rest.service.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.rest.service.client.CalculatorSOAPClient;
import ru.rest.service.service.CalculatorService;
import ru.rest.service.wsdl.*;

@Service
public class CalculatorServiceImplementation implements CalculatorService {
    private ObjectFactory factory = new ObjectFactory();

    private CalculatorSOAPClient calculatorSOAPClient;

    @Autowired
    public CalculatorServiceImplementation(CalculatorSOAPClient calculatorSOAPClient) {
        this.calculatorSOAPClient = calculatorSOAPClient;
    }

    @Override
    @Cacheable("addOperationCache")
    public int callAddOperation(int firstNumber, int secondNumber) {
        Add addOperation = factory.createAdd();
        addOperation.setIntA(firstNumber);
        addOperation.setIntB(secondNumber);
        AddResponse addOperationResponse = calculatorSOAPClient.getAddResponse(addOperation);

        return addOperationResponse.getAddResult();
    }

    @Override
    @Cacheable("divideOperationCache")
    public int callDivideOperation(int firstNumber, int secondNumber) {
        Divide divideOperation = factory.createDivide();
        divideOperation.setIntA(firstNumber);
        divideOperation.setIntB(secondNumber);
        DivideResponse divideOperationResponse = calculatorSOAPClient.getDivideResponse(divideOperation);

        return divideOperationResponse.getDivideResult();
    }

    @Override
    @Cacheable("multiplyOperationCache")
    public int callMultiplyOperation(int firstNumber, int secondNumber) {
        Multiply multiplyOperation = factory.createMultiply();
        multiplyOperation.setIntA(firstNumber);
        multiplyOperation.setIntB(secondNumber);
        MultiplyResponse multiplyOperationResponse = calculatorSOAPClient.getMultiplyResponse(multiplyOperation);

        return multiplyOperationResponse.getMultiplyResult();
    }

    @Override
    @Cacheable("subtractOperationCache")
    public int callSubtractOperation(int firstNumber, int secondNumber) {
        Subtract subtractOperation = factory.createSubtract();
        subtractOperation.setIntA(firstNumber);
        subtractOperation.setIntB(secondNumber);
        SubtractResponse subtractOperationResponse = calculatorSOAPClient.getSubtractResponse(subtractOperation);

        return subtractOperationResponse.getSubtractResult();
    }
}
