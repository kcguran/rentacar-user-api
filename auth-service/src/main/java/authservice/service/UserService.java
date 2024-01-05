package authservice.service;

import authservice.entity.UserEntity;

import java.util.Optional;

public interface UserService {

    Optional<UserEntity> findByUsername(String username);

    Optional<UserEntity> findByEmail(String email);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

    boolean existsByPhone(String phone);

    boolean existsByIdentityNumber(String identityNumber);

    void saveUser(UserEntity userEntity);

}
