package ru.lanit.service;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.lanit.dto.request.CarDTO;
import ru.lanit.model.Car;
import ru.lanit.repository.CarRepository;
import ru.lanit.repository.PersonRepository;

import java.time.LocalDate;
import java.time.Period;


@Service
public class CarServiceImpl implements CarService {

    private final PersonRepository personRepository;
    private final CarRepository carRepository;

    public CarServiceImpl(PersonRepository personRepository, CarRepository carRepository) {
        this.personRepository = personRepository;
        this.carRepository = carRepository;
    }

    @Override
    public ResponseEntity add(CarDTO carDTO) {
        Car car = getCarFromCarRequestDTO(carDTO);
        if (Period.between(car.getPersons().getBirthdate(), LocalDate.now()).getYears() < 18) {
            return ResponseEntity.badRequest().build();
        }
        carRepository.save(car);
        return ResponseEntity.ok().build();
    }

    private Car getCarFromCarRequestDTO(CarDTO carDTO) {
        return Car.builder()
                .id(carDTO.getId())
                .model(carDTO.getModel())
                .horsepower(carDTO.getHorsepower())
                .persons(personRepository.findById(carDTO.getOwnerId())
                        .orElseThrow(() -> new IllegalArgumentException("Пользователя с ID: " + carDTO.getOwnerId() +
                                " - не существует")))
                .build();
    }


}
