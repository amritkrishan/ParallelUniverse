package com.universe.tasks.service;


import com.universe.tasks.model.Family;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.universe.tasks.repository.FamilyRepository;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FamilyServiceImpl implements FamilyService
{
    @Autowired
    private FamilyRepository familyRepository;


    @Transactional
    public void saveFamily(Family family)
    {
        familyRepository.save(family);
    }
    @Transactional
    public List<Family> getAllFamilies()
    {
        return familyRepository.findAll();
    }

    public List<String> getFamiliesForUniverse(int id){
        return familyRepository.
                getFamiliesForUniverse(id).
                stream().
                map(Family::getFamilyName).
                collect(Collectors.toList());
    }

}