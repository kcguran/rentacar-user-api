package authservice.service.impl;

import authservice.entity.UserEntity;
import authservice.entity.dto.RegisterDto;
import authservice.exceptions.AppException;
import authservice.mapper.AuthMapper;
import authservice.repository.UserRepository;
import authservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public Optional<UserEntity> findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<UserEntity> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public boolean existsByPhone(String phone) {
        return userRepository.existsByPhone(phone);
    }

    @Override
    public boolean existsByIdentityNumber(String identityNumber) {
        return userRepository.existsByIdentityNumber(identityNumber);
    }

    @Transactional
    @Override
    public void saveUser(UserEntity userEntity) {
        this.userRepository.save(userEntity);
    }

}
