package com.universe.tasks.repository;

import com.universe.tasks.model.Universe;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UniverseRepository extends JpaRepository<Universe, Integer> {
    Universe findById(int universeId);
}