package reservationservice.service;

import reservationservice.entity.dto.ReservationCreateDto;
import reservationservice.entity.dto.ReservationResponseDto;

public interface ReservationService {

    ReservationResponseDto createReservation(ReservationCreateDto reservationCreateDto);
}
