package com.hyla.dto;

import com.hyla.model.Mutant;

import lombok.Data;

@Data
public class MutantLite {
    private Long id;
    private String name;
    private boolean alive;
    
    MutantLite(Mutant m){
        this.id = m.getId();
        this.name = m.getName();
        this.alive = m.isAlive();
    }
}
