package com.universe.tasks.resource;

import com.universe.tasks.model.Family;
import com.universe.tasks.repository.UniverseRepository;
import com.universe.tasks.service.FamilyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks/family")
public class FamilyResource {

    @Autowired
    private
    FamilyServiceImpl familyServiceImpl;

    @Autowired
    private
    UniverseRepository universeRepository;


    @PostMapping("/createfamily")
    public void create(@RequestBody Family family){
        if(universeRepository.findById(family.getCompositeKey().getUniverseId())!=null) {
            List<Family> families=familyServiceImpl.getAllFamilies();
            for (Family f : families) {
                if (f.getCompositeKey().getFamilyId() == family.getCompositeKey().getFamilyId() && f.getCompositeKey().getUniverseId() == family.getCompositeKey().getUniverseId()) {
                    System.out.print("Family already present in Universe " + family.getCompositeKey().getUniverseId());
                    return;
                }
            }
            familyServiceImpl.saveFamily(family);
        }
        else {
            System.out.println("Universe doesn't exist");
        }
    }

    @GetMapping("/id/{id}")
    public List<String> getId(@PathVariable("id") final int id) {
        return familyServiceImpl.getFamiliesForUniverse(id);
    }
}