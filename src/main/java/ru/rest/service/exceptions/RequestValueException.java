package ru.rest.service.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.rest.service.model.error.Error;

import java.util.List;

@Data
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequestValueException extends RuntimeException{
    private List<Error> errors;

    public RequestValueException(List<Error> errors) {
        this.errors = errors;
    }
}
