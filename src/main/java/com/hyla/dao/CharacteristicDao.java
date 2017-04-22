package com.hyla.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hyla.model.Characteristic;

public interface CharacteristicDao extends JpaRepository<Characteristic, Long> {

}
