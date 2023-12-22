package apigateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @GetMapping("/userServiceFallBack")
    public String userServiceFallback() {
        return "User Service is down!";
    }

    @GetMapping("/carServiceFallBack")
    public String carServiceFallback() {
        return "Car Service is down!";
    }

    @GetMapping("/reservationServiceFallBack")
    public String reservationServiceFallback() {
        return "Reservation Service is down!";
    }

    @GetMapping("/authServiceFallBack")
    public String authServiceFallback() {
        return "Auth Service is down!";
    }

}
