package com.hyla.dto;

import java.util.Set;

import com.hyla.model.Ability;

import lombok.Data;

@Data
public class MutantCURequest {
    private String name;
    private Set<Ability> abilities;
    private boolean alive;

}
