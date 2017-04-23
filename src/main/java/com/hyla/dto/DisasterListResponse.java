package com.hyla.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.hyla.model.Disaster;

import lombok.Data;

@Data
public class DisasterListResponse {
    private List<DisasterLite> data;

    public DisasterListResponse(Collection<Disaster> data) {
        super();
        this.data = new ArrayList<DisasterLite>();
        data.forEach(disaster -> this.data.add(new DisasterLite(disaster)));
    }
    
}
