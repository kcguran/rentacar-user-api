package reservationservice.controller;

import org.springframework.web.bind.annotation.*;
import reservationservice.entity.dto.ReservationCreateDto;
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


    @PostMapping(value = "/create")
    public AppResponse<ReservationResponseDto> createReservation(@RequestBody ReservationCreateDto reservationCreateDto) {
        return AppResponse.success(reservationService.createReservation(reservationCreateDto));
    }


    @GetMapping
    public AppResponse<List<ReservationResponseDto>> getAllReservation() {
        return getAllReservation();
    }

}
