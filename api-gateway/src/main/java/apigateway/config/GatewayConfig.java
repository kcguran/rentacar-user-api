package apigateway.config;

import apigateway.JwtAuthenticationFilter;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.GatewayFilterSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.gateway.route.builder.UriSpec;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.ServerHttpResponse;

import java.util.function.Function;

@Configuration
public class GatewayConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public GatewayConfig(JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder, JwtAuthenticationFilter jwtAuthenticationFilter) {
        return builder.routes()
                .route("rentacar-user-api-userservice", r -> r.path("/api/users/**")
                        .filters(f -> f.filter(jwtAuthenticationFilter).filters(brutalCorsFilters()))
                        .uri("lb://rentacar-user-api-userservice"))
                .route("rentacar-user-api-carservice", r -> r.path("/api/cars/**")
                        .filters(f -> f.filter(jwtAuthenticationFilter).filters(brutalCorsFilters()))
                        .uri("lb://rentacar-user-api-carservice"))
                .route("rentacar-user-api-reservationservice", r -> r.path("/api/reservation/**")
                        .filters(f -> f.filter(jwtAuthenticationFilter).filters(brutalCorsFilters()))
                        .uri("lb://rentacar-user-api-reservationservice"))
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
