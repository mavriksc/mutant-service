package com.hyla.dto;

import com.hyla.model.Squad;

import lombok.Data;

@Data
public class SquadResponse {
    private SquadDTO data;

    public SquadResponse(Squad data) {
        super();
        this.data = new SquadDTO(data);
    }
    

}
