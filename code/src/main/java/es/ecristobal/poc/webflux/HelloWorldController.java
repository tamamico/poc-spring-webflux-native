package es.ecristobal.poc.webflux;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import static reactor.core.publisher.Mono.just;

@RestController
class HelloWorldController {

    private static final String GREETING_TEMPLATE = "Hello, %s!";

    @GetMapping("/greet/{name}")
    public Mono<String> greet(final @PathVariable String name) {
        return just(GREETING_TEMPLATE.formatted(name));
    }

}
