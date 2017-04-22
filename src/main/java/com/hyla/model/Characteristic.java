package com.hyla.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Characteristic {
    @Id
    @GeneratedValue
    private Long id;
    private String description;
    public Characteristic(String description) {
        super();
        this.description = description;
    }
    public Characteristic() {
        super();
    }
    
}
