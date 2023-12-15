package userservice.mapper;

import org.mapstruct.Mapper;
import userservice.entity.UserEntity;
import userservice.entity.dto.LoginDto;
import userservice.other.mapper.ReferenceMapperHelper;

@Mapper(componentModel = "spring", uses = {
        ReferenceMapperHelper.class
})
public interface UserMapper {

    UserEntity mapLoginDtoToUserEntity(LoginDto source);
}
