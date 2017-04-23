package com.hyla.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.hyla.model.Mutant;

import lombok.Data;

@Data
public class MutantListResponse {
    private List<MutantLite> data;

    public MutantListResponse(Collection<Mutant> data) {
        super();
        this.data = new ArrayList<MutantLite>();
        data.forEach(mutant -> this.data.add(new MutantLite(mutant)));
    }
    

}
