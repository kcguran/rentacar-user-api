package authservice.mapper;

import authservice.entity.UserEntity;
import authservice.entity.dto.RegisterDto;
import authservice.other.mapper.ReferenceMapperHelper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = {
        ReferenceMapperHelper.class
})
public interface AuthMapper {

    UserEntity mapRegisterDtoToUserEntity(RegisterDto registerDto);
}
