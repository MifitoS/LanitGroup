package ru.lanit.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.Set;


@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Car {
    public Car() {

    }

    @Id
    private Long id;

    private String model;

    private Integer horsepower;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Person persons;
}
