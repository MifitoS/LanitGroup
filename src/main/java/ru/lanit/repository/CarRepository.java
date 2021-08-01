package ru.lanit.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.lanit.model.Car;
import ru.lanit.model.Person;

//работа с бд
@Repository
public interface CarRepository extends CrudRepository<Car, Long> {

    @Query(value = "select count(distinct (model))\n" +
            "from car",
            nativeQuery = true)
    Long getUniqueVendorCount();
}
