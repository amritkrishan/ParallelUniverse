package com.universe.tasks.service;

import com.universe.tasks.model.Family;
import com.universe.tasks.model.Universe;
import com.universe.tasks.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class BalanceServiceImpl {

    public BalanceServiceImpl() {
    }

    private final HashMap<Integer, HashMap<Integer, Integer>> posMap = new LinkedHashMap<>();
    private final HashMap<Integer, HashMap<Integer, Integer>> negMap = new LinkedHashMap<>();

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private UniverseServiceImpl universeServiceImpl;

    @Autowired
    private FamilyServiceImpl familyServiceImpl;


    public Set<Integer> findUnbalancedPowers(){
        Set<Integer> set=new HashSet<>();
        List<Family> families=familyServiceImpl.getAllFamilies();
        List<Universe> universes = universeServiceImpl.getAllUniverses();
        for (Family f: families){
            int fid=f.getCompositeKey().getFamilyId();
            int tmpPosCount=-1;
            int tmpNegCount=-1;
            for (Universe u: universes){
                int uid=u.getUniverseId();
                int posCount=0;
                int negCount=0;
                if(personRepository.getGroupedPersonPositiveData(uid,fid)!=null){
                    posCount=personRepository.getGroupedPersonPositiveData(uid,fid);
                }
                else {
                    posCount=0;
                }
                if(personRepository.getGroupedPersonNegativeData(uid,fid)!=null){
                    negCount=personRepository.getGroupedPersonNegativeData(uid,fid);
                }
                else {
                    negCount=0;
                }
                if(tmpPosCount==-1 && tmpNegCount==-1){
                   tmpPosCount=posCount;
                   tmpNegCount=negCount;
                   continue;
                }
                else if(posCount==tmpPosCount && negCount==tmpNegCount){
                    continue;
                }
                else{
                    set.add(fid);
                }
            }
        }
        return set;
    }
}
