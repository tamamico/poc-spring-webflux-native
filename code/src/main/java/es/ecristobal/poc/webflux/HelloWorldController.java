package es.ecristobal.poc.webflux;

import io.opentelemetry.instrumentation.annotations.WithSpan;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
class HelloWorldController {

    private static final String GREETING_TEMPLATE = "Greeting %s!";

    @WithSpan
    @GetMapping(path = "/greet/{name}", produces = MediaType.TEXT_PLAIN_VALUE)
    String greet(final @PathVariable String name) {
        log.atInfo()
           .setMessage("Greeting {}")
           .addArgument(name)
           .log();
        return GREETING_TEMPLATE.formatted(name);
    }

}
