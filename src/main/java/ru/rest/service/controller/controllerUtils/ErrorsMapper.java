package ru.rest.service.controller.controllerUtils;

import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import ru.rest.service.model.error.Error;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ErrorsMapper {

    public static List<Error> objectErrorsToValidationErrors(List<ObjectError> errors){
        return errors.stream()
                .map(error -> error instanceof FieldError ?
                        new Error(((FieldError) error).getField() + " " + error.getDefaultMessage()) :
                        new Error(error.getDefaultMessage())).collect(Collectors.toList());
    }
}
