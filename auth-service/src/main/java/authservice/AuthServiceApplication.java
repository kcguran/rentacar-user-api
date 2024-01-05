package authservice;

import authservice.entity.UserEntity;
import authservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableFeignClients
public class AuthServiceApplication {

	@Autowired
	PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(AuthServiceApplication.class, args);
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
		userService.saveUser(user);
	}

	//TODO MERNIS DOGRULAMA EKLENECEK
}
