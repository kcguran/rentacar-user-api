package com.kcguran.rentacaruser.reservationservice.controller;

import com.kcguran.rentacaruser.reservationservice.entity.dto.ReservationResponseDto;
import com.kcguran.rentacaruser.reservationservice.mapper.ReservationMapper;
import com.kcguran.rentacaruser.reservationservice.other.AppResponse;
import com.kcguran.rentacaruser.reservationservice.service.ReservationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/car")
public class ReservationController {

    private final ReservationService reservationService;
    private final ReservationMapper reservationMapper;

    public ReservationController(ReservationService reservationService, ReservationMapper reservationMapper) {
        this.reservationService = reservationService;
        this.reservationMapper = reservationMapper;
    }


    @GetMapping
    public AppResponse<List<ReservationResponseDto>> getAllCars() {
        return getAllCars();
    }

}
