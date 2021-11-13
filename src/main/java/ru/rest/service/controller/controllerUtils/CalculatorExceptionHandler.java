package ru.rest.service.controller.controllerUtils;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.rest.service.exceptions.RequestValueException;
import ru.rest.service.model.error.Error;

import java.util.List;

@ControllerAdvice
@RestController
public class CalculatorExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({RequestValueException.class})
    protected List<Error> handleOperationRequestValueException(RequestValueException e){

        return e.getErrors();
    }
}
