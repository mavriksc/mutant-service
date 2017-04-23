package com.hyla.dto;

import com.hyla.model.Disaster;

import lombok.Data;

@Data
public class DisasterLite {
    private Long id;
    private String name;
    public DisasterLite(Disaster d) {
        super();
        this.id = d.getId();
        this.name = d.getName();
    }
    

}
