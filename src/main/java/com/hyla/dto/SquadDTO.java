package com.hyla.dto;

import java.util.ArrayList;
import java.util.List;

import com.hyla.model.Squad;

import lombok.Data;

@Data
public class SquadDTO {
    private Long id;
    private List<MutantLite> mutants;
    
    public SquadDTO(Squad s) {
        super();
        this.id= s.getId();
        this.mutants = new ArrayList<MutantLite>();
        s.getMutants().forEach(mutant -> this.mutants.add(new MutantLite(mutant)));
    }
}
