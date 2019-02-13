package com.universe.tasks.repository;

import com.universe.tasks.model.Person;
import com.universe.tasks.model.PersonId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface PersonRepository extends JpaRepository<Person, PersonId> {

    @Query(value="SELECT * FROM person",nativeQuery = true)
    List<Person> findAll();

    @Query(value="SELECT * FROM person WHERE universe_id = ?1 AND family_id = ?1 AND power = 'positive'",nativeQuery = true)
    List<Person> getFilteredPersonsPositive(int universeId,int familyId);

    @Query(value="SELECT * FROM person WHERE universe_id = ?1 AND family_id = ?1 AND power = 'negative'",nativeQuery = true)
    List<Person> getFilteredPersonsNegative(int universeId,int familyId);

    @Query(value="Select Count(*) from person p Where power='positive' Group by universe_id,family_id HAVING universe_id=?1 AND family_id=?2",nativeQuery = true)
    Integer getGroupedPersonPositiveData(int universeId,int familyId);

    @Query(value="Select Count(*) from person p Where power='negative' Group by universe_id,family_id HAVING universe_id=?1 AND family_id=?2",nativeQuery = true)
    Integer getGroupedPersonNegativeData(int universeId,int familyId);

}
