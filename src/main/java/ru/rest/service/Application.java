package ru.rest.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import ru.rest.service.client.CalculatorSOAPClient;
import ru.rest.service.wsdl.Add;
import ru.rest.service.wsdl.AddResponse;
import ru.rest.service.wsdl.Divide;
import ru.rest.service.wsdl.DivideResponse;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableCaching
@EnableSwagger2
public class Application {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        CalculatorSOAPClient calculatorSOAPClient = ctx.getBean(CalculatorSOAPClient.class);
        Divide add = new Divide();
        add.setIntA(10);
        add.setIntB(5);
        DivideResponse response = calculatorSOAPClient.getDivideResponse(add);
        System.out.println(response.getDivideResult());
    }

}
