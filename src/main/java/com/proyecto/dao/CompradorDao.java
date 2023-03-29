package com.proyecto.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.entities.Comprador;


public interface CompradorDao extends JpaRepository<Comprador, Integer> {
    
}
