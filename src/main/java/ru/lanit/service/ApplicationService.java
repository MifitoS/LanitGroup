package ru.lanit.service;

import ru.lanit.dto.response.StatisticDTO;

public interface ApplicationService {

    /**
     * Метод, который удаляет все данные по Person и Car из нашей бд.
     */
    void clearAll();

    /**
     * @return Возвращает DTO со статистикой по Person, Car {@link StatisticDTO}
     */
    StatisticDTO getStatistic();
}
