package com.universe.tasks.resource;

import com.universe.tasks.model.Universe;
import com.universe.tasks.service.UniverseServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/tasks/universe")
@Api(value="balance", description="Operations pertaining to universe")
public class UniverseResource {

    @Autowired
    private
    UniverseServiceImpl universeServiceImpl;

    @ApiOperation(value = "Get Universe Details for particular universe", response= Universe.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved universe details")
    })
    @GetMapping("/id/{id}")
    public Universe getId(@PathVariable("id") final Integer id) {
        return universeServiceImpl.getUniverseById(id);
    }

    @ApiOperation(value = "Create a new universe")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created new universe")
    })
    @PostMapping("/create")
    public void create(@RequestBody Universe universe){
        universeServiceImpl.saveUniverse(universe);
    }
}
