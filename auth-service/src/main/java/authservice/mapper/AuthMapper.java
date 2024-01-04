package authservice.mapper;

import authservice.entity.UserEntity;
import authservice.entity.dto.RegisterDto;
import authservice.other.mapper.ReferenceMapperHelper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = {
        ReferenceMapperHelper.class
})
public interface AuthMapper {


    @Mapping(target = "password", expression = "java(encodedPassword)")
    UserEntity mapRegisterDtoToUserEntity(RegisterDto registerDto,String encodedPassword);
}
