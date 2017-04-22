package com.hyla.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Ability {
    @Id
    @GeneratedValue
    private Long id;
    private String description;
    
    public Ability(String description){
        this.description = description;
    }

    public Ability() {
        super();
    }
    
    

}
