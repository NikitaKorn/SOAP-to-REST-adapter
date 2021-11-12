package ru.rest.service.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import ru.rest.service.wsdl.*;

public class CalculatorSOAPClient extends WebServiceGatewaySupport {
    private static final String URI = "http://www.dneonline.com/calculator.asmx";
    private static final String ADD_URI = "http://tempuri.org/Add";
    private static final String DIVIDE_URI = "http://tempuri.org/Divide";
    private static final String MULTIPLY_URI = "http://tempuri.org/Multiply";
    private static final String SUBTRACT_URI = "http://tempuri.org/Subtract";

    public AddResponse getAddResponse(Add addRequest){
        return (AddResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        URI,
                        addRequest,
                        new SoapActionCallback(ADD_URI)
                );
    }

    public DivideResponse getDivideResponse(Divide divideRequest){
        return (DivideResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        URI,
                        divideRequest,
                        new SoapActionCallback(DIVIDE_URI)
                );
    }

    public MultiplyResponse getMultiplyResponse(Multiply multiplyRequest){
        return (MultiplyResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        URI,
                        multiplyRequest,
                        new SoapActionCallback(MULTIPLY_URI)
                );
    }

    public SubtractResponse getSubtractResponse(Subtract subtractRequest){
        return (SubtractResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        URI,
                        subtractRequest,
                        new SoapActionCallback(SUBTRACT_URI)
                );
    }
}
