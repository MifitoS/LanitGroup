package ru.lanit.validation;

import lombok.*;

import java.io.Serializable;


@Data
@Builder
public class ErrorDTO implements Serializable {

    private final String field;
    private final String description;

    public ErrorDTO(String field, String description) {
        this.field = field;
        this.description = description;
    }
}

