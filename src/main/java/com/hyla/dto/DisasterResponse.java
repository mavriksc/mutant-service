package com.hyla.dto;

import com.hyla.model.Disaster;

import lombok.Data;

@Data
public class DisasterResponse {
    private DisasterDTO data;

    public DisasterResponse(Disaster data) {
        super();
        this.data = new DisasterDTO(data);
    }
    
}
