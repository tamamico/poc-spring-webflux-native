package es.ecristobal.poc.webflux;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.server.SecurityWebFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebFluxSecurity
class SpringSecurityConfiguration {

    @Bean
    MapReactiveUserDetailsService userDetailsService() {
        @SuppressWarnings({ "deprecation", "java:S1874", "java:S6437" })
        UserDetails user = User.withDefaultPasswordEncoder()
                               .username("user")
                               .password("password")
                               .roles("USER")
                               .build();
        return new MapReactiveUserDetailsService(user);
    }

    @Bean
    public SecurityWebFilterChain springWebFilterChain(final ServerHttpSecurity http) {
        //@formatter:off
        http.authorizeExchange(authorize -> authorize
                    .pathMatchers("/actuator/health/**").permitAll()
                    .anyExchange().authenticated()
            )
            .httpBasic(withDefaults())
            .formLogin(withDefaults());
        //@formatter:on
        return http.build();
    }

}
