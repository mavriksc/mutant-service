package com.hyla.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Disaster {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToMany
    private Set<Characteristic> characteristic;
    @OneToOne
    private Squad squad;
    private DisasterState state;
    private boolean disasterAvoided;
    
    public Disaster(String name) {
        super();
        this.name = name;
        state = DisasterState.INCOMING;
    }
    public Disaster() {
        super();
    }
    
    
    
}
