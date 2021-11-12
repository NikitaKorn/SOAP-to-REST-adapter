package ru.rest.service.service;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.DataBinder;
import org.springframework.validation.ObjectError;
import ru.rest.service.model.OperationRequest;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class OperationRequestValidatorTest {
    private static final String VALUE_CAN_NOT_BE_NULL = "Value can't be null";
    private static final String VALUE_MUST_BE_INTEGER = "Value must be int type";

    private static final String EMPTY = "";

    @Autowired
    OperationRequestValidator requestValidator;

    @Test
    public void emptyValueTest(){
        OperationRequest operationRequest = new OperationRequest();
        operationRequest.setFirstNumber("");
        operationRequest.setSecondNumber("12");

        DataBinder dataBinder = new DataBinder(operationRequest);
        dataBinder.addValidators(requestValidator);
        dataBinder.validate();

        List<ObjectError> errors = dataBinder.getBindingResult().getAllErrors();

        Assert.assertTrue(errors.size() == 1);
        Assert.assertTrue(errors.get(0).getDefaultMessage().equals(VALUE_MUST_BE_INTEGER));
    }

    @Test
    public void nullValueTest(){
        OperationRequest operationRequest = new OperationRequest();
        operationRequest.setFirstNumber("12");
        operationRequest.setSecondNumber(null);

        DataBinder dataBinder = new DataBinder(operationRequest);
        dataBinder.addValidators(requestValidator);
        dataBinder.validate();

        List<ObjectError> errors = dataBinder.getBindingResult().getAllErrors();
        List<String> defaultMsg = new ArrayList<>();

        for(ObjectError str : errors){
            defaultMsg.add(str.getDefaultMessage());
        }

        Assert.assertTrue(errors.size() == 2);
        Assert.assertTrue(defaultMsg.contains(VALUE_MUST_BE_INTEGER));
        Assert.assertTrue(defaultMsg.contains(VALUE_CAN_NOT_BE_NULL));
    }

    @Test
    public void notIntegerValueTest(){
        OperationRequest operationRequest = new OperationRequest();
        operationRequest.setFirstNumber("12");
        operationRequest.setSecondNumber("dva");

        DataBinder dataBinder = new DataBinder(operationRequest);
        dataBinder.addValidators(requestValidator);
        dataBinder.validate();

        List<ObjectError> errors = dataBinder.getBindingResult().getAllErrors();

        Assert.assertTrue(errors.size() == 1);
        Assert.assertTrue(errors.get(0).getDefaultMessage().equals(VALUE_MUST_BE_INTEGER));
    }

    @Test
    public void correctDataTest(){
        OperationRequest operationRequest = new OperationRequest();
        operationRequest.setFirstNumber("12");
        operationRequest.setSecondNumber("5");

        DataBinder dataBinder = new DataBinder(operationRequest);
        dataBinder.addValidators(requestValidator);
        dataBinder.validate();

        List<ObjectError> errors = dataBinder.getBindingResult().getAllErrors();
        Assert.assertTrue(errors.size() == 0);
    }
}