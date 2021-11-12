package ru.rest.service.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.rest.service.model.OperationRequest;

@Service
public class OperationRequestValidator implements Validator {
    private static final String FIELD_CAN_NOT_BE_EMPTY = "Field can't be empty";
    private static final String FIELD_CAN_NOT_BE_NULL = "Field can't be null";
    private static final String VALUE_CAN_NOT_BE_NULL = "Value can't be null";
    private static final String VALUE_MUST_BE_INTEGER = "Value must be int type";

    private static final String EMPTY = "";

    private static final String VALUE_NEGATIVE = "value.negative";
    private static final String FIRST_NUMBER = "firstNumber";
    private static final String SECOND_NUMBER = "secondNumber";


    @Override
    public boolean supports(Class<?> clazz) {
        return OperationRequest.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        OperationRequest request = (OperationRequest) target;
        fieldValidation(FIRST_NUMBER, request.getFirstNumber(), errors);
        fieldValidation(SECOND_NUMBER, request.getSecondNumber(), errors);
    }

    private void fieldValidation(String field, String value, Errors errors){
        if(field == null){
            errors.rejectValue(field, VALUE_NEGATIVE, FIELD_CAN_NOT_BE_NULL);
        }
        if(field.equals(EMPTY)){
            errors.rejectValue(field, VALUE_NEGATIVE, FIELD_CAN_NOT_BE_EMPTY);
        }
//        if(value.equals(EMPTY)){
//            errors.rejectValue(field, VALUE_MUST_BE_INTEGER);
//        }
        if(value == null){
            errors.rejectValue(field, VALUE_NEGATIVE, VALUE_CAN_NOT_BE_NULL);
        }
        if(isNumberInteger(value) == false){
            errors.rejectValue(field, VALUE_NEGATIVE, VALUE_MUST_BE_INTEGER);
        }

    }

    private boolean isNumberInteger(String number){
        try{
            Integer.parseInt(number);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
