package carservice.controller;

import carservice.entity.dto.CarDtoResponse;
import carservice.mapper.CarMapper;
import carservice.other.AppResponse;
import carservice.repository.CarRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    public CarController(CarRepository carRepository, CarMapper carMapper) {
        this.carRepository = carRepository;
        this.carMapper = carMapper;
    }

    @GetMapping
    public String getAllCars(){
        return "CarService Başarılı";
    }

}
