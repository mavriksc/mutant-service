package com.hyla.dto;

import java.util.ArrayList;
import java.util.List;

import com.hyla.model.Characteristic;
import com.hyla.model.Disaster;
import com.hyla.model.DisasterState;

import lombok.Data;
@Data
public class DisasterDTO {
    private Long id;
    private String name;
    private SquadDTO squad;
    private DisasterState state;
    private boolean disasterAverted;
    private List<Characteristic> characteristics;
    
    public DisasterDTO(Disaster d) {
        super();
        this.id = d.getId();
        this.name = d.getName();
        this.squad = d.getSquad() != null ? new SquadDTO(d.getSquad()) : null;
        this.disasterAverted = d.isDisasterAvoided();
        this.state = d.getState();
        this.characteristics= new ArrayList<Characteristic>();
        this.characteristics.addAll(d.getCharacteristics());
    }

}
