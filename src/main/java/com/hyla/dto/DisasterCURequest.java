package com.hyla.dto;

import java.util.Set;

import com.hyla.model.Characteristic;
import com.hyla.model.DisasterState;
import com.hyla.model.Squad;

import lombok.Data;

@Data
public class DisasterCURequest {
    private String name;
    private Set<Characteristic> characteristics;
    private Squad squad;
    private DisasterState state;
    private boolean disasterAvoided;
    

}
