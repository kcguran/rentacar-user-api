package com.kcguran.rentacaruser.reservationservice.mapper;

import com.kcguran.rentacaruser.reservationservice.entity.Reservation;
import com.kcguran.rentacaruser.reservationservice.entity.dto.ReservationResponseDto;
import com.kcguran.rentacaruser.reservationservice.other.mapper.ReferenceMapperHelper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {
        ReferenceMapperHelper.class
})
public interface ReservationMapper {

    ReservationResponseDto mapCarToCarResponseDto(Reservation source);
}
