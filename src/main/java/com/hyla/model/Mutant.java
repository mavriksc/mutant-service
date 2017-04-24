package com.hyla.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.hyla.dto.MutantCURequest;

import lombok.Data;

@Data
@Entity
public class Mutant {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<Ability> abilities;
    private boolean alive;
    
    public Mutant(String name) {
        super();
        this.name = name;
        this.alive = true;
        this.abilities = new HashSet<Ability>();
    }

    public Mutant() {
        super();
    }
    
    public void updateFromRequest(MutantCURequest mutantCUR) {
        this.name = mutantCUR.getName();
        this.abilities = mutantCUR.getAbilities();        
        this.alive = mutantCUR.isAlive();    
    }
}
