package reservationservice.service.impl;

import org.springframework.stereotype.Service;
import reservationservice.entity.dto.ReservationCreateDto;
import reservationservice.entity.dto.ReservationResponseDto;
import reservationservice.repository.ReservationRepository;
import reservationservice.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }


    @Override
    public ReservationResponseDto createReservation(ReservationCreateDto reservationCreateDto) {

        return null;
    }
}
