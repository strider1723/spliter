package com.yourname.billsplitter.demo.controller;

import com.yourname.billsplitter.demo.Services.PersonService;
import com.yourname.billsplitter.demo.entity.Person;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/persons")
@CrossOrigin(origins = "*")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public Person addPerson(@RequestBody Person person) {
        return personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPersons(@RequestParam(required = false) String search) {
        if (search != null) {
            return personService.searchByName(search);
        }
        return personService.getAllPersons();
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable Long id) {
        return personService.getPersonById(id);
    }

    @PatchMapping("/{id}/name")
    public Person updateName(@PathVariable Long id, @RequestBody String newName) {
        return personService.updatePersonName(id, newName);
    }
}
