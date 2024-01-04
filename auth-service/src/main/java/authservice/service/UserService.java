package authservice.service;

import authservice.entity.UserEntity;

import java.util.Optional;

public interface UserService {

    Optional<UserEntity> findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByPhone(String phone);

    void saveUser(UserEntity userEntity);

}
