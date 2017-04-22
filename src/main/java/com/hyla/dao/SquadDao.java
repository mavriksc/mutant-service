package com.hyla.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hyla.model.Squad;

public interface SquadDao extends JpaRepository<Squad, Long> {

}
