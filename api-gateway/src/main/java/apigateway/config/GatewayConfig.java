package apigateway.config;

import apigateway.filter.JwtAuthenticationFilter;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.ServerHttpResponse;

@Configuration
public class GatewayConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public GatewayConfig(JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        System.out.println("Kerem");
        return builder.routes()
                .route("rentacar-user-api-userservice", r -> r.path("/users/**")
                        .filters(f -> f.filter(jwtAuthenticationFilter))
                        .uri("lb://rentacar-user-api-userservice"))
                .route("rentacar-user-api-carservice", r -> r.path("/cars/**")
                        .filters(f -> f.filter(jwtAuthenticationFilter))
                        .uri("lb://rentacar-user-api-carservice"))
                .route("rentacar-user-api-reservationservice", r -> r.path("/reservation/**")
                        .filters(f -> f.filter(jwtAuthenticationFilter))
                        .uri("lb://rentacar-user-api-reservationservice"))
                .route("rentacar-user-api-authservice", r -> r.path("/auth/**")
                        .uri("lb://rentacar-user-api-authservice"))
                .build();
    }
    @Bean
    public GatewayFilter brutalCorsFilters() {
        return (exchange, chain) -> {
            ServerHttpResponse response = exchange.getResponse();
            response.getHeaders().add("Access-Control-Allow-Origin", "*");
            response.getHeaders().add("Access-Control-Allow-Methods", "*");
            response.getHeaders().add("Access-Control-Expose-Headers", "*");
            return chain.filter(exchange);
        };
    }
}
