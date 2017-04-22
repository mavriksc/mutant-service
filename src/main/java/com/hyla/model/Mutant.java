package com.hyla.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


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
    }

    public Mutant() {
        super();
    }
    
    public void copy(Mutant m){
        this.name=m.getName();
        this.abilities=m.getAbilities();
        this.alive = m.isAlive();        
    }
}
