package userservice.service;

import org.springframework.stereotype.Service;
import userservice.entity.UserEntity;
import userservice.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> getAllUsers(){
        return this.userRepository.findAll();
    }
}
