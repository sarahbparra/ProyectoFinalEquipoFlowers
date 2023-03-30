package com.proyecto.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.entities.Comprador;

@Repository
public interface AdministradorDao extends JpaRepository<Comprador, Integer> {



}