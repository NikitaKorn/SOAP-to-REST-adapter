package ru.rest.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import ru.rest.service.client.CalculatorSOAPClient;

@Configuration
public class CalculatorSOAPClientConfiguration {
    private static final String RU_SERVICE_ADAPTER_WSDL = "ru.rest.service.wsdl";

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath(RU_SERVICE_ADAPTER_WSDL);
        return marshaller;
    }

    @Bean
    public CalculatorSOAPClient calculatorSOAPClient(Jaxb2Marshaller marshaller) {
        CalculatorSOAPClient client = new CalculatorSOAPClient();
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
