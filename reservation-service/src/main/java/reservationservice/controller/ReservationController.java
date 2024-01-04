package reservationservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reservationservice.entity.dto.ReservationResponseDto;
import reservationservice.mapper.ReservationMapper;
import reservationservice.other.AppResponse;
import reservationservice.service.ReservationService;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    private final ReservationService reservationService;
    private final ReservationMapper reservationMapper;

    public ReservationController(ReservationService reservationService, ReservationMapper reservationMapper) {
        this.reservationService = reservationService;
        this.reservationMapper = reservationMapper;
    }


    @GetMapping
    public AppResponse<List<ReservationResponseDto>> getAllReservation() {
        return getAllReservation();
    }

}
