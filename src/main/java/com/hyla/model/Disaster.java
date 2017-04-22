package com.hyla.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<Characteristic> characteristic;
    @OneToOne
    private Squad squad;
    private DisasterState state;
    private boolean disasterAvoided;
    
    public Disaster(String name) {
        super();
        this.name = name;
        this.characteristic = new HashSet<Characteristic>();
        state = DisasterState.INCOMING;
    }
    public Disaster() {
        super();
    }
    public void copy(Disaster disaster) {
        this.name= disaster.getName();
        this.characteristic.clear();
        this.characteristic.addAll(disaster.getCharacteristic());
        this.state = disaster.getState();
        this.disasterAvoided = disaster.isDisasterAvoided();        
    }
    
    
    
}
