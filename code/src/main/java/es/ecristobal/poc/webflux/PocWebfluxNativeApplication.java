package es.ecristobal.poc.webflux;

import io.opentelemetry.api.OpenTelemetry;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static org.springframework.boot.SpringApplication.run;
import static reactor.core.publisher.Hooks.enableAutomaticContextPropagation;

@SpringBootApplication
public class PocWebfluxNativeApplication {

    public static void main(String[] args) {
        enableAutomaticContextPropagation();
        run(PocWebfluxNativeApplication.class, args);
    }

    @Bean
    InitializingBean openTelemetryAppenderInitializer(final OpenTelemetry openTelemetry) {
        return new OpenTelemetryAppenderInitializer(openTelemetry);
    }

}
