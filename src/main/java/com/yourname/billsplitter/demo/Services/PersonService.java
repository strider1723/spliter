package com.yourname.billsplitter.demo.Services;

import com.yourname.billsplitter.demo.entity.Person;

import java.util.List;

public interface PersonService {
    Person addPerson(Person person);
    List<Person> getAllPersons();
    Person getPersonById(Long id);
}