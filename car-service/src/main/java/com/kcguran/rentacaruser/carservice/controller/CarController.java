package com.kcguran.rentacaruser.carservice.controller;

import com.kcguran.rentacaruser.carservice.entity.dto.CarDtoResponse;
import com.kcguran.rentacaruser.carservice.mapper.CarMapper;
import com.kcguran.rentacaruser.carservice.other.AppResponse;
import com.kcguran.rentacaruser.carservice.repository.CarRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/car")
public class CarController {

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    public CarController(CarRepository carRepository, CarMapper carMapper) {
        this.carRepository = carRepository;
        this.carMapper = carMapper;
    }

    @GetMapping
    public AppResponse<List<CarDtoResponse>> getAllCars(){
        return getAllCars();
    }

}
