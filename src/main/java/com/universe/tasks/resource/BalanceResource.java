package com.universe.tasks.resource;


import com.universe.tasks.service.BalanceServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/tasks/balance")
@Api(value="balance", description="Operations pertaining to balancing families")
public class BalanceResource {

    @Autowired
    private BalanceServiceImpl balanceServiceImpl;

    @ApiOperation(value = "Find families that are unbalanced in universes", response=Set.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully found unbalanced families")
    })
    @GetMapping("/families")
    public Set<Integer> unbalancedPowers(){
        return balanceServiceImpl.findUnbalancedPowers();
    }

}
