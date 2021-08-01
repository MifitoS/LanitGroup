package ru.lanit.service;


import org.springframework.http.ResponseEntity;
import ru.lanit.dto.request.CarDTO;

public interface CarService {

    /** Метод, добавляющий машину в бд
     * @param carDTO данные о добавляемой машине
     */
    ResponseEntity add(CarDTO carDTO);
}
