package com.universe.tasks.resource;

import com.universe.tasks.model.Universe;
import com.universe.tasks.service.UniverseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/tasks/universe")
public class UniverseResource {

    @Autowired
    private
    UniverseServiceImpl universeServiceImpl;

    @GetMapping("/id/{id}")
    public Universe getId(@PathVariable("id") final Integer id) {
        return universeServiceImpl.getUniverseById(id);
    }

    @PostMapping("/create")
    public void create(@RequestBody Universe universe){
        universeServiceImpl.saveUniverse(universe);
    }
}
