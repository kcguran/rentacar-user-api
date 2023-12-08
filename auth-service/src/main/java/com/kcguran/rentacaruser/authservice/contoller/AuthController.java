package com.kcguran.rentacaruser.authservice.contoller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @GetMapping(value = "/getAllAuth")
    public ResponseEntity<Boolean> getAll() {
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
