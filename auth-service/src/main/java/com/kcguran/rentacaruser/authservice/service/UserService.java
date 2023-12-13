package com.kcguran.rentacaruser.authservice.service;

import com.kcguran.rentacaruser.authservice.entity.UserEntity;
import com.kcguran.rentacaruser.authservice.repository.UserRepository;
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
