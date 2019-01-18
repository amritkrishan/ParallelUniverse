package com.universe.tasks.service;

import com.universe.tasks.model.Person;

import java.util.List;

public interface PersonService
{
    void savePerson(Person person);
    List<Person> getAllPersons();
}