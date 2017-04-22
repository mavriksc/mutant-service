package com.hyla.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.hyla.model.Disaster;

import lombok.Data;

@Data
public class DisasterListResponse {
    private List<Disaster> data;

    public DisasterListResponse(Collection<Disaster> data) {
        super();
        this.data = new ArrayList<Disaster>();
        this.data.addAll(data);
    }
    
}
