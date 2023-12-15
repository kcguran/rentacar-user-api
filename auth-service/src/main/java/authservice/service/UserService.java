package authservice.service;

import authservice.entity.UserEntity;
import authservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Optional<UserEntity> findByUsername(String username){
        return userRepository.findByUsername(username);
    }
}
