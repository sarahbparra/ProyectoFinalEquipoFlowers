package com.proyecto.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.entities.Administrador;

@Repository
public interface AdministradorDao extends JpaRepository<Administrador, Integer> {

}