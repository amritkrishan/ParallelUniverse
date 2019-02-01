package com.universe.tasks.resource;

import com.universe.tasks.model.Person;
import com.universe.tasks.service.PersonServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks/person")
@Api(value="balance", description="Operations pertaining to person")
public class PersonResource {

    @Autowired
    private
    PersonServiceImpl personServiceImpl;

    @ApiOperation(value = "Create a new person in a family in a particular universe")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created new person")
    })
    @PostMapping("/createperson")
    public void create(@RequestBody Person person){
        List<Person> list=personServiceImpl.getAllPersons();
        for (Person p : list) {
            if (p.getCompositeKey().getPersonId() == person.getCompositeKey().getPersonId() && p.getCompositeKey().getUniverseId() == person.getCompositeKey().getUniverseId()) {
                System.out.println("Person already present in Universe " + person.getCompositeKey().getUniverseId());
                return;
            }
        }
        personServiceImpl.savePerson(person);
    }
}