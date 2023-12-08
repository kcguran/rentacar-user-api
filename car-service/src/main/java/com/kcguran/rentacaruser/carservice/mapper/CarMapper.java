package com.kcguran.rentacaruser.carservice.mapper;

import com.kcguran.rentacaruser.carservice.entity.CarEntity;
import com.kcguran.rentacaruser.carservice.entity.dto.CarDtoResponse;
import com.kcguran.rentacaruser.carservice.other.mapper.ReferenceMapperHelper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {
        ReferenceMapperHelper.class
})
public interface CarMapper {

    @Mapping(target = "personCount", source = "carDetail.personCount")
    CarDtoResponse mapCarToCarResponseDto(CarEntity source);
}
