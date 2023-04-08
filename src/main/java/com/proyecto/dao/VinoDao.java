package com.proyecto.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.entities.Vino;

public interface VinoDao extends JpaRepository <Vino,  Integer> {
  



}
