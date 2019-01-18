package com.universe.tasks.service;


import com.universe.tasks.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.universe.tasks.repository.PersonRepository;

import java.util.List;

@Component
public class PersonServiceImpl implements PersonService
{
    @Autowired
    private PersonRepository personRepository;


    @Transactional
    public void savePerson(Person person)
    {
        personRepository.save(person);
    }
    @Transactional
    public List<Person> getAllPersons()
    {
        return personRepository.findAll();
    }
}