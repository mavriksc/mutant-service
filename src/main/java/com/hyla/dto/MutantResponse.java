package com.hyla.dto;

import com.hyla.model.Mutant;

import lombok.Data;

@Data
public class MutantResponse {
    private Mutant data;

    public MutantResponse(Mutant data) {
        super();
        this.data = data;
    }
    

}
