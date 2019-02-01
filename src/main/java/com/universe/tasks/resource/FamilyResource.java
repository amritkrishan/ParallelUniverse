package com.universe.tasks.resource;

import com.universe.tasks.model.Family;
import com.universe.tasks.repository.UniverseRepository;
import com.universe.tasks.service.FamilyServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks/family")
@Api(value="family", description="Operations pertaining to family in Parallel Universe")
public class FamilyResource {

    @Autowired
    private
    FamilyServiceImpl familyServiceImpl;

    @Autowired
    private
    UniverseRepository universeRepository;

    @ApiOperation(value = "Create a new family in a particular universe")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created new family")
    })
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

    @ApiOperation(value = "Get List of families in a particular universe", response= List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list of families for given universe")
    })
    @GetMapping("/id/{id}")
    public List<String> getId(@PathVariable("id") final int id) {
        return familyServiceImpl.getFamiliesForUniverse(id);
    }
}