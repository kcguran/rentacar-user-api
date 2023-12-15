package userservice.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import userservice.entity.UserEntity;
import userservice.entity.dto.LoginDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-15T15:43:43+0300",
    comments = "version: 1.5.0.RC1, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserEntity mapLoginDtoToUserEntity(LoginDto source) {
        if ( source == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setUsername( source.getUsername() );
        userEntity.setPassword( source.getPassword() );

        return userEntity;
    }
}
