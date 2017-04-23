package com.hyla.dto;

import com.hyla.model.Mutant;

import lombok.Data;

@Data
public class MutantLite {
    private Long id;
    private String name;
    
    MutantLite(Mutant m){
        this.id = m.getId();
        this.name = m.getName();
    }
}
