package reservationservice.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import reservationservice.entity.Reservation;
import reservationservice.entity.dto.ReservationResponseDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-21T14:41:04+0300",
    comments = "version: 1.5.0.RC1, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class ReservationMapperImpl implements ReservationMapper {

    @Override
    public ReservationResponseDto mapCarToCarResponseDto(Reservation source) {
        if ( source == null ) {
            return null;
        }

        ReservationResponseDto reservationResponseDto = new ReservationResponseDto();

        return reservationResponseDto;
    }
}
