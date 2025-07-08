package com.yourname.billsplitter.demo.service.impl;



import com.yourname.billsplitter.demo.Services.PersonService;
import com.yourname.billsplitter.demo.entity.Person;
import com.yourname.billsplitter.demo.repository.PersonRepository;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person addPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public Person getPersonById(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new RuntimeException("Person not found!"));
    }
}
