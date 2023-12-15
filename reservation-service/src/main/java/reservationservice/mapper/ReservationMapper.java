package reservationservice.mapper;

import org.mapstruct.Mapper;
import reservationservice.entity.Reservation;
import reservationservice.entity.dto.ReservationResponseDto;
import reservationservice.other.mapper.ReferenceMapperHelper;

@Mapper(componentModel = "spring", uses = {
        ReferenceMapperHelper.class
})
public interface ReservationMapper {

    ReservationResponseDto mapCarToCarResponseDto(Reservation source);
}
