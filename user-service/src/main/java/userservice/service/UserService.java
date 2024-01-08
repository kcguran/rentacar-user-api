package userservice.service;

import org.springframework.stereotype.Service;
import userservice.entity.UserEntity;
import userservice.repository.UserRepository;
import userservice.security.UserPrincipal;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<UserEntity> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public List<UserEntity> getAllUsers() {
        return this.userRepository.findAll();
    }

    public void saveUser(UserEntity user){
        this.userRepository.save(user);
    }
}
