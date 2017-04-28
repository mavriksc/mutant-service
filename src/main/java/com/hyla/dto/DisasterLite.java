package com.hyla.dto;

import com.hyla.model.Disaster;
import com.hyla.model.DisasterState;

import lombok.Data;

@Data
public class DisasterLite {
    private Long id;
    private String name;
    private DisasterState state;
    private boolean disasterAvoided;
    public DisasterLite(Disaster d) {
        super();
        this.id = d.getId();
        this.name = d.getName();
        this.state = d.getState();
        this.disasterAvoided = d.isDisasterAvoided();
    }
    

}
