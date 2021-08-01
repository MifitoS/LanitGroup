package ru.lanit.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarDTO {

    @NotNull
    private Long id;

    @NotBlank
    private String model;

    @Min(1)
    @NotNull
    private Integer horsepower;

    @NotNull
    private Long ownerId;
}
