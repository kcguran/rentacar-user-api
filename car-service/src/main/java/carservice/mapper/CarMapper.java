package carservice.mapper;

import carservice.entity.CarEntity;
import carservice.entity.dto.CarDtoResponse;
import carservice.other.mapper.ReferenceMapperHelper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {
        ReferenceMapperHelper.class
})
public interface CarMapper {

    @Mapping(target = "personCount", source = "carDetail.personCount")
    CarDtoResponse mapCarToCarResponseDto(CarEntity source);
}
