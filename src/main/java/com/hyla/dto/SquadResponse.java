package com.hyla.dto;

import com.hyla.model.Squad;

import lombok.Data;

@Data
public class SquadResponse {
    private Squad data;

    public SquadResponse(Squad data) {
        super();
        this.data = data;
    }
    

}
