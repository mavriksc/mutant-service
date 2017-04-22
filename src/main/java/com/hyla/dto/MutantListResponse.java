package com.hyla.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.hyla.model.Mutant;

import lombok.Data;

@Data
public class MutantListResponse {
    private List<Mutant> data;

    public MutantListResponse(Collection<Mutant> data) {
        super();
        this.data = new ArrayList<Mutant>();
        this.data.addAll(data);
    }
    

}
