package ru.rest.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ru.rest.service.controller.controllerUtils.ErrorsMapper;
import ru.rest.service.exceptions.RequestValueException;
import ru.rest.service.model.OperationRequest;
import ru.rest.service.model.OperationResponse;
import ru.rest.service.service.CalculatorService;
import ru.rest.service.service.OperationRequestValidator;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/v1/calculator", produces = MediaType.APPLICATION_JSON_VALUE)
public class CalculatorControllerV1 {
    CalculatorService calculatorService;

    OperationRequestValidator validator;

    @Autowired
    public CalculatorControllerV1(CalculatorService calculatorService, OperationRequestValidator validator) {
        this.calculatorService = calculatorService;
        this.validator = validator;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder){
        binder.setValidator(validator);
    }

    @PostMapping("/add")
    public OperationResponse addOperation(@RequestBody @Valid OperationRequest request, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new RequestValueException(
                    ErrorsMapper.objectErrorsToValidationErrors(
                            bindingResult.getAllErrors()
                    )
            );
        }

        return new OperationResponse(
          calculatorService.callAddOperation(
                  Integer.valueOf(request.getFirstNumber()),
                  Integer.valueOf(request.getSecondNumber())
          )
        );
    }

    @PostMapping("/divide")
    public OperationResponse divideOperation(@RequestBody @Valid OperationRequest request, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new RequestValueException(
                    ErrorsMapper.objectErrorsToValidationErrors(
                            bindingResult.getAllErrors()
                    )
            );
        }

        return new OperationResponse(
                calculatorService.callDivideOperation(
                        Integer.valueOf(request.getFirstNumber()),
                        Integer.valueOf(request.getSecondNumber())
                )
        );
    }

    @PostMapping("/multiply")
    public OperationResponse multiplyOperation(@RequestBody @Valid OperationRequest request, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new RequestValueException(
                    ErrorsMapper.objectErrorsToValidationErrors(
                            bindingResult.getAllErrors()
                    )
            );
        }

        return new OperationResponse(
                calculatorService.callMultiplyOperation(
                        Integer.valueOf(request.getFirstNumber()),
                        Integer.valueOf(request.getSecondNumber())
                )
        );
    }

    @PostMapping("/subtract")
    public OperationResponse subtractOperation(@RequestBody @Valid OperationRequest request, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new RequestValueException(
                    ErrorsMapper.objectErrorsToValidationErrors(
                            bindingResult.getAllErrors()
                    )
            );
        }

        return new OperationResponse(
                calculatorService.callSubtractOperation(
                        Integer.valueOf(request.getFirstNumber()),
                        Integer.valueOf(request.getSecondNumber())
                )
        );
    }


}
