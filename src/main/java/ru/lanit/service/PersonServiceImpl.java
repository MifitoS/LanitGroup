package ru.lanit.service;


import org.springframework.stereotype.Service;
import ru.lanit.dto.request.CarDTO;
import ru.lanit.dto.request.PersonDTO;
import ru.lanit.dto.response.PersonWithCarsDTO;
import ru.lanit.model.Car;
import ru.lanit.model.Person;
import ru.lanit.repository.CarRepository;
import ru.lanit.repository.PersonRepository;

import java.util.Set;
import java.util.stream.Collectors;

//Service тоже самое делает, что и компонент
@Service
public class PersonServiceImpl implements PersonService {


    private final PersonRepository personRepository;
    private final CarRepository carRepository;

    public PersonServiceImpl(PersonRepository personRepository, CarRepository carRepository) {
        this.personRepository = personRepository;
        this.carRepository = carRepository;
    }


    @Override
    public void add(PersonDTO personDTO) {
        Person person = getPersonFromPersonAddDTO(personDTO);
        personRepository.save(person);
    }


    @Override
    public PersonWithCarsDTO get(Long id) {
        Person person = personRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Person с таким ID: " + id + " - не существует"));

        Set<Car> cars = person.getCars();


        return PersonWithCarsDTO.builder()
                .id(person.getId())
                .car(cars.stream()
                        .map(car -> CarDTO.builder()
                                .id(car.getId())
                                .model(car.getModel())
                                .horsepower(car.getHorsepower())
                                .ownerId(car.getId())
                                .build()).collect(Collectors.toSet()))
                .name(person.getName())
                .birthdate(person.getBirthdate())
                .build();
    }


    private Person getPersonFromPersonAddDTO(PersonDTO personDTO) {
        return Person.builder()
                .id(personDTO.getId())
                .name(personDTO.getName())
                .birthdate(personDTO.getBirthdate())
                .build();
    }
}
