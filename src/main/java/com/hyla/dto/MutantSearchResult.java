package com.hyla.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.hyla.model.Mutant;

import lombok.Data;

@Data
public class MutantSearchResult {
    private List<Mutant> data;
    
    public MutantSearchResult(Collection<Mutant> mutants){
        this.data = new ArrayList<Mutant>(mutants);
    }

}
