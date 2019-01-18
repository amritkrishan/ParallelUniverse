package com.universe.tasks.repository;

import com.universe.tasks.model.Family;
import com.universe.tasks.model.FamilyId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface FamilyRepository extends JpaRepository<Family, FamilyId> {

    @Query(value="SELECT * FROM family WHERE universe_id = ?1",nativeQuery = true)
    List<Family> getFamiliesForUniverse(int id);

}
