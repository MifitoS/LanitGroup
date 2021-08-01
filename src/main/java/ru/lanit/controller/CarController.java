package ru.lanit.controller;


import org.springframework.web.bind.annotation.*;
import ru.lanit.dto.request.CarDTO;
import ru.lanit.service.CarService;

@RestController
@RequestMapping(path = "/car")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping(path = "/add")
    public void add(@RequestBody CarDTO car){
        carService.add(car);
    }


}
