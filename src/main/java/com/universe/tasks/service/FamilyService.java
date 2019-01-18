package com.universe.tasks.service;

import com.universe.tasks.model.Family;


import java.util.List;

public interface FamilyService
{

    void saveFamily(Family family);
    List<Family> getAllFamilies();
}