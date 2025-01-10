package es.ecristobal.poc.webflux;

import org.springframework.boot.SpringApplication;

public class TestPocWebfluxNativeApplication {

    public static void main(String[] args) {
        SpringApplication.from(PocWebfluxNativeApplication::main)
                         .with(TestcontainersConfiguration.class)
                         .run(args);
    }

}
