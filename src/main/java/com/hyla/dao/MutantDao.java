package com.hyla.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hyla.model.Mutant;

public interface MutantDao extends JpaRepository<Mutant, Long> {
    
    Set<Mutant> abilitiesDescriptionContains(String token);

}
