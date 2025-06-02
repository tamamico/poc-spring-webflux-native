package es.ecristobal.poc.webflux;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.springframework.boot.SpringApplication.run;
import static reactor.core.publisher.Hooks.enableAutomaticContextPropagation;

@SpringBootApplication
public class PocWebfluxNativeApplication {

    public static void main(String[] args) {
        enableAutomaticContextPropagation();
        run(PocWebfluxNativeApplication.class, args);
    }

}
