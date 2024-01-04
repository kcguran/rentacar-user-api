package authservice.contoller;

import authservice.entity.UserEntity;
import authservice.entity.dto.RegisterDto;
import authservice.exceptions.UserAllreadyExistException;
import authservice.mapper.AuthMapper;
import authservice.other.AppResponse;
import authservice.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final AuthMapper authMapper;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserService userService, AuthMapper authMapper, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.authMapper = authMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping(value = "/register")
    public AppResponse<Boolean> register(@RequestBody RegisterDto registerDto) {
        if (!userService.existsByUsername(registerDto.getUsername()) || !userService.existsByPhone(registerDto.getPhone())) {
            // TODO MERNIS DOGRULAMA EKLENECEK
//            if (!checkMernis(signUpDto.getFirstname(), signUpDto.getLastname(), Long.parseLong(signUpDto.getTcno()), signUpDto.getBirthYear())) {
//                throw new AppException("Verileriniz doğrulanamadı!");
//            }
            UserEntity user = authMapper.mapRegisterDtoToUserEntity(registerDto, passwordEncoder.encode(registerDto.getPassword()));
            userService.saveUser(user);
            // TODO Kullanıcı kayıt olduktan sonra SMS ve MAIL doğrulaması gerçekleştirilecek

        } else {
            throw new UserAllreadyExistException("Kullanıcı zaten kayıtlı.");
        }
        return AppResponse.success(true);
    }

    @GetMapping(value = "/login")
    public AppResponse<UserEntity> login(/* @RequestBody RegisterDto registerDto*/) {
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
