package apigateway;

import apigateway.config.RouterValidator;
import apigateway.util.JwtUtil;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter implements GatewayFilter {

    private final JwtUtil jwtUtil;

    private final RouterValidator routerValidator;


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        ServerHttpRequest request = exchange.getRequest();

        if (routerValidator.isSecured.test(request)) {
            if ((!request.getHeaders().containsKey("Authorization"))) {
                return onError(exchange,HttpStatus.UNAUTHORIZED);
            }

            final String authorization = request.getHeaders().getOrEmpty("Authorization").get(0);
            final String token = authorization.replace("Bearer ", "");

            try {
                jwtUtil.validateToken(token);
            } catch (Exception exception) {
                return onError(exchange,HttpStatus.UNAUTHORIZED);
            }
            Claims claims = jwtUtil.getClaims(token);
            exchange.getRequest().mutate().header("username", String.valueOf(claims.get("username"))).build();
        }
        return chain.filter(exchange);
    }

    private Mono<Void> onError(ServerWebExchange exchange, HttpStatus httpStatus) {
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(httpStatus);
        return response.setComplete();
    }
}
