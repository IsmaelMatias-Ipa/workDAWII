package cibertec.pe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

@Configuration
public class AppConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
       return builder.routes()
       .route("rest-employee", r -> r
            .path("/api/employee/**")
            .uri("lb://Rest-Employee"))
       .route("saludo-service", r -> r
            .path("/api/saludo/**")
            .uri("lb://Saludo-Service"))
       .route("rest-cuenta", r -> r
            .path("/api/Cuenta/**")
            .uri("lb://Rest-Cuenta"))
       .route("identity-service", r -> r
            .path("/api/identity/**")
            .uri("lb://Identity-Service"))
       .build();
    }
}
