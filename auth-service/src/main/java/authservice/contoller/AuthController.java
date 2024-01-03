package authservice.contoller;

import authservice.entity.UserEntity;
import authservice.entity.dto.RegisterDto;
import authservice.other.AppResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @GetMapping(value = "/register")
    public AppResponse<UserEntity> register(@RequestBody RegisterDto registerDto) {
        System.out.println("Deneme");
        return AppResponse.success(UserEntity.builder()
                .id(1L)
                .username("kcguran")
                .email("keremcangurann@hotmail.com")
                .firstname(null)
                .identityNumber(null)
                .enabled(true)
                .phone(null)
                .password(null)
                .lastname(null)
                .build());
    }

    @GetMapping(value = "/login")
    public AppResponse<UserEntity> login(/* @RequestBody RegisterDto registerDto*/ ) {
        System.out.println("Deneme");
        return AppResponse.success(UserEntity.builder()
                .id(1L)
                .username("kcguran")
                .email("keremcangurann@hotmail.com")
                .firstname(null)
                .identityNumber(null)
                .enabled(true)
                .phone(null)
                .password(null)
                .lastname(null)
                .build());
    }
}
