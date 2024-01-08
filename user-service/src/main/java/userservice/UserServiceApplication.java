package userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import userservice.entity.UserEntity;
import userservice.service.UserService;

@SpringBootApplication
@EnableFeignClients
public class UserServiceApplication {

    @Autowired
    PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner init(UserService userService){
        return args -> {
            initDB(userService);
        };
    }

    private void initDB(UserService userService){
        UserEntity user = new UserEntity();
        user.setEnabled(true);
        user.setFirstname("Kerem Can");
        user.setLastname("Güran");
        user.setUsername("kcguran");
        user.setEmail("keremcangurann@hotmail.com");
        user.setPassword(passwordEncoder.encode("123456"));
        user.setPhone("05304720634");
        user.setPhoneVerification(true);
        userService.saveUser(user);
    }
}
