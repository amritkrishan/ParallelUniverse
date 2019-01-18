package com.universe.tasks.service;

import com.universe.tasks.model.Universe;

import java.util.List;

public interface UniverseService
{
    Universe getUniverseById(int id);
    void saveUniverse(Universe universe);
    List<Universe> getAllUniverses();
}