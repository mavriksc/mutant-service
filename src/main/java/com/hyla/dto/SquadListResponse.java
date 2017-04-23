package com.hyla.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.hyla.model.Squad;

import lombok.Data;

@Data
public class SquadListResponse {
    private List<SquadDTO> data;

    public SquadListResponse(Collection<Squad> data) {
        super();
        this.data = new ArrayList<SquadDTO>();
        data.forEach(squad -> this.data.add(new SquadDTO(squad)));
    }
}
