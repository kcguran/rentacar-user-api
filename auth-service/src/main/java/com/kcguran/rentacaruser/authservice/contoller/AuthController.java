package com.kcguran.rentacaruser.authservice.contoller;

import com.kcguran.rentacaruser.authservice.entity.UserEntity;
import com.kcguran.rentacaruser.authservice.entity.dto.RegisterDto;
import com.kcguran.rentacaruser.authservice.entity.shared.AppResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @GetMapping(value = "/register")
    public AppResponse<UserEntity> register(@RequestBody @Valid RegisterDto registerDto) {
        UserEntity user = new UserEntity();
        return AppResponse.success(user);
    }
}
