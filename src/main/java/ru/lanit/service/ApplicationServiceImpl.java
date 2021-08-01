package ru.lanit.service;

import org.springframework.stereotype.Service;
import ru.lanit.dto.response.StatisticDTO;
import ru.lanit.repository.CarRepository;
import ru.lanit.repository.PersonRepository;

@Service
public class ApplicationServiceImpl implements ApplicationService {


    private final PersonRepository personRepository;
    private final CarRepository carRepository;

    public ApplicationServiceImpl(PersonRepository personRepository, CarRepository carRepository) {
        this.personRepository = personRepository;
        this.carRepository = carRepository;
    }

    @Override
    public void clearAll() {
        carRepository.deleteAll();
        personRepository.deleteAll();
    }

    @Override
    public StatisticDTO getStatistic() {

        Long carcount = carRepository.count();
        Long personcount = personRepository.count();
        Long uniquevendorcount = carRepository.getUniqueVendorCount();

        return StatisticDTO.builder()
                .carcount(carcount)
                .personcount(personcount)
                .uniquevendorcount(uniquevendorcount)
                .build();
    }
}
