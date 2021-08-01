package ru.lanit.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.lanit.dto.request.CarDTO;

import java.time.LocalDate;
import java.util.Set;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonWithCarsDTO {


    Long id;
    String name;
    LocalDate birthdate;

    Set<CarDTO> car;

}
