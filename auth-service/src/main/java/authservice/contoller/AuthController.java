package authservice.contoller;

import authservice.entity.UserEntity;
import authservice.entity.dto.*;
import authservice.exceptions.AppException;
import authservice.exceptions.SmsValidationException;
import authservice.exceptions.UserAllreadyExistException;
import authservice.mapper.AuthMapper;
import authservice.other.AppResponse;
import authservice.other.SpringUtils;
import authservice.repository.UserRepository;
import authservice.security.jwt.JwtTokenProvider;
import authservice.service.SmsVerificationService;
import authservice.service.UserService;
import authservice.util.Util;
import jakarta.validation.Valid;
import lombok.SneakyThrows;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    // TODO SMS göndermek için servis yazılacak

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final AuthMapper authMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    private final SmsVerificationService smsVerificationService;

    public AuthController(AuthenticationManager authenticationManager,
                          UserService userService,
                          AuthMapper authMapper,
                          PasswordEncoder passwordEncoder,
                          UserRepository userRepository, JwtTokenProvider jwtTokenProvider, SmsVerificationService smsVerificationService) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.authMapper = authMapper;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.jwtTokenProvider = jwtTokenProvider;
        this.smsVerificationService = smsVerificationService;
    }

    @SneakyThrows
    @PostMapping(value = "/login")
    public AppResponse<UserEntity> login(@RequestBody LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Optional<UserEntity> user = userService.findByUsername(userDetails.getUsername());
        UserEntity userEntity = user.orElseThrow(() -> new AppException("Hata"));
        if (userEntity.isPhoneVerification()) {
            smsVerificationService.saveRegisterSmsCodeToCache(userEntity.getUsername(), prodOrLocalCode());
//            userEntity.setLoginSms(SpringUtils.isProd() ? Util.getRandomCode(6) : "123456");
//            userService.saveUser(userEntity);
//            smsSender.send(SmsRequestDto.builder().phones(user.getPhone()).message(Util.smsFill(user.getSmsToken())).build());
        }
        return AppResponse.success(userEntity);
    }

    @PostMapping(value = "/sms-verification")
    public AppResponse<JwtResponseDTO> smsVerification(@RequestBody @Valid SmsVerificationDto smsVerificationDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(smsVerificationDto.getUsername(), smsVerificationDto.getPassword()));
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        UserEntity userEntity = userService.findByUsername(userDetails.getUsername()).orElseThrow(() -> new AppException("Hata"));
        String smsToken = smsVerificationService.getRegisterSmsCodeFromCache(userEntity.getUsername());
        if (!smsVerificationDto.getSmsCode().equals(smsToken)) {
            throw new SmsValidationException("Doğrulama Kodu Hatalı");
        }
        String jwtToken = jwtTokenProvider.generateToken(authentication);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return AppResponse.success(new JwtResponseDTO(jwtToken, userEntity.getUsername()));
    }

    @SneakyThrows
    @PostMapping(value = "/register")
    public AppResponse<Boolean> register(@RequestBody RegisterDto registerDto) {
        if (!userService.existsByUsername(registerDto.getUsername())
                || !userService.existsByPhone(registerDto.getPhone())
                || !userService.existsByEmail(registerDto.getEmail())
                || !userService.existsByIdentityNumber(registerDto.getIdentityNumber())) {

            // TODO MERNIS DOGRULAMA EKLENECEK
//            if (!checkMernis(signUpDto.getFirstname(), signUpDto.getLastname(), Long.parseLong(signUpDto.getTcno()), signUpDto.getBirthYear())) {
//                throw new AppException("Verileriniz doğrulanamadı!");
//            }
            UserEntity user = authMapper.mapRegisterDtoToUserEntity(registerDto, passwordEncoder.encode(registerDto.getPassword()));
            user.setRegisterSms(prodOrLocalCode());
            userService.saveUser(user);
            // TODO Kullanıcı kayıt olduktan sonra SMS doğrulaması gerçekleştirilecek

        } else {
            throw new UserAllreadyExistException("Kullanıcı zaten kayıtlı.");
        }
        return AppResponse.success(true);
    }


    @PutMapping(value = "/forgot-password")
    public AppResponse<UserEntity> forgotPassword(@RequestBody ForgotPasswordDto forgotPasswordDto) {
        if (userService.findByEmail(forgotPasswordDto.getEmail()).isPresent()) {
            UserEntity user = userService.findByEmail(forgotPasswordDto.getEmail()).get();
            user.setForgotPasswordSms(prodOrLocalCode());
            userRepository.save(user);
            // TODO Kullanıcı şifremi unuttum kısmında SMS doğrulaması gerçekleştirilecek
            // smsSender.send(user.getEmail(), Util.emailFill(user.getSignupEmail()));
            return AppResponse.success(user);
        }
        throw new AppException("Şifre sıfırlama adımı başarısız -> Lütfen daha sonra tekrar deneyin!");

    }


    private static String prodOrLocalCode() {
        return SpringUtils.isProd() ? Util.getRandomCode(6) : "123456";
    }


}
