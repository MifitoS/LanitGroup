package ru.lanit.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;


@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Person {
    public Person() {
    }

    @Id
    private Long id;

    private String name;

    private LocalDate birthdate;


    @OneToMany(mappedBy = "persons", fetch = FetchType.LAZY)
    private Set<Car> cars;

}
