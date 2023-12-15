package authservice.contoller;

import authservice.entity.UserEntity;
import authservice.entity.dto.RegisterDto;
import authservice.other.AppResponse;
import jakarta.validation.Valid;
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
