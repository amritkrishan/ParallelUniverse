package com.universe.tasks.service;


import com.universe.tasks.model.Universe;
import com.universe.tasks.repository.UniverseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class UniverseServiceImpl implements UniverseService
{
    @Autowired
    private UniverseRepository universeRepository;

    @Transactional
    public Universe getUniverseById(int id)
    {
        return universeRepository.findById(id);
    }
    @Transactional
    public void saveUniverse(Universe universe)
    {
        universeRepository.save(universe);
    }
    @Transactional
    public List<Universe> getAllUniverses()
    {
        return universeRepository.findAll();
    }
}