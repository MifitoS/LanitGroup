package ru.lanit.controller;

import org.springframework.web.bind.annotation.*;
import ru.lanit.dto.response.PersonWithCarsDTO;
import ru.lanit.dto.request.PersonDTO;
import ru.lanit.service.PersonService;
import javax.validation.Valid;

@RestController
@RequestMapping(path = "/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    @PostMapping(path = "/add")
    public void add(@Valid @RequestBody PersonDTO person) {
             personService.add(person);
    }

    @GetMapping(path = "/personwithcars")
    public PersonWithCarsDTO get(@RequestParam(name = "personId") Long id) {
        return personService.get(id);
    }
}
