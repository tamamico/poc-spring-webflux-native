package es.ecristobal.poc.webflux;

import java.security.Principal;
import java.util.List;

import jakarta.annotation.PostConstruct;
import org.slf4j.MDC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.WebFilter;

import static io.micrometer.context.ContextRegistry.getInstance;
import static reactor.core.publisher.Hooks.enableAutomaticContextPropagation;

@Configuration
class SpringWebfluxConfiguration {

    private static final List<String> FIELDS = List.of("user.name");

    @PostConstruct
    public void init() {
        enableAutomaticContextPropagation();
    }

    @Bean
    WebFilter webFilter() {
        FIELDS.forEach(field -> getInstance().registerThreadLocalAccessor(field,
                                                                          () -> MDC.get(field),
                                                                          username -> MDC.put(field, username),
                                                                          () -> MDC.remove(field)));
        return (exchange, chain) -> exchange.getPrincipal()
                                            .map(Principal::getName)
                                            .flatMap(principal -> chain.filter(exchange)
                                                                       .contextWrite(context -> context.put("user.name",
                                                                                                            principal)));
    }

}
