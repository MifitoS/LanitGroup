package ru.lanit.service;

import ru.lanit.dto.response.PersonWithCarsDTO;
import ru.lanit.dto.request.PersonDTO;

public interface PersonService {

    /** Метод, добавляющий человека в бд
     * @param personDTO данные о добавляемом человеке
     */
    void add(PersonDTO personDTO);

    /** Метод для получения списка владельцев
     * @param id id владельца
     * @return
     */
    PersonWithCarsDTO get(Long id);
}
