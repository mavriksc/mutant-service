package com.hyla.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.hyla.dto.SquadCURequest;

import lombok.Data;

@Data
@Entity
public class Squad {
    @Id
    @GeneratedValue
    private Long id;
    //private String name;
    @OneToMany
    private Set<Mutant> mutants;
    
    public Squad(){
        super();
        mutants = new HashSet<Mutant>();
    }
}
