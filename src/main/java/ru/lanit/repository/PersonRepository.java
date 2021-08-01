package ru.lanit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.lanit.model.Person;

//работа с бд
@Repository
public interface PersonRepository extends CrudRepository<Person,Long> {
}
