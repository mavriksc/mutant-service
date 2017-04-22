package com.hyla.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hyla.model.Disaster;

public interface DisasterDao extends JpaRepository<Disaster, Long> {

}
