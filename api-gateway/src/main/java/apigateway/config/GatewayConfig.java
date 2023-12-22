package apigateway.config;

import apigateway.filter.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.GatewayFilterSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.gateway.route.builder.UriSpec;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
@RequiredArgsConstructor
public class GatewayConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder, Function<GatewayFilterSpec, UriSpec> brutalCorsFilters) {
        return builder.routes().route("AUTH-SERVICE", r -> r.path("/authenticate/**").filters(brutalCorsFilters).uri("lb://AUTH-SERVICE"))
                .route("USER-SERVICE", r -> r.path("/users/**").filters(brutalCorsFilters).uri("lb://USER-SERVICE"))
                .route("CAR-SERVICE", r -> r.path("/car/**").filters(brutalCorsFilters).uri("lb://CAR-SERVICE"))
                .route("RESERVATION-SERVICE", r -> r.path("/reservation/**").filters(brutalCorsFilters).uri("lb://RESERVATION-SERVICE")).build();
    }

    @Bean
    Function<GatewayFilterSpec, UriSpec> brutalCorsFilters() {
        return f -> f
                .setResponseHeader("Access-Control-Allow-Origin", "*")
                .setResponseHeader("Access-Control-Allow-Methods", "*")
                .setResponseHeader("Access-Control-Expose-Headers", "*");
    }
}
