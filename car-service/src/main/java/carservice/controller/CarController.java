package carservice.controller;

import carservice.mapper.CarMapper;
import carservice.repository.CarRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
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
