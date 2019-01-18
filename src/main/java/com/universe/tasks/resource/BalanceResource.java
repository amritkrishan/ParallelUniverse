package com.universe.tasks.resource;


import com.universe.tasks.service.BalanceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/tasks/balance")
public class BalanceResource {

    @Autowired
    private BalanceServiceImpl balanceServiceImpl;

    @GetMapping("/families")
    public Set<Integer> unbalancedPowers(){
        return balanceServiceImpl.findUnbalancedPowers();
    }

}
