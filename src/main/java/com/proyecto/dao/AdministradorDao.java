package com.proyecto.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.entities.Administrador;

import jakarta.transaction.Transactional;

/**
 * 
 * Esta interfaz define la capa DAO para la entidad Administrador.
 * Utiliza Spring Data JPA para proporcionar métodos CRUD básicos para la
 * entidad.
 */
@Repository
@Transactional //¿Sería de yacarta?
public interface AdministradorDao extends JpaRepository<Administrador, Integer> {
    
}
/**
 
 * La interfaz extiende la interfaz JpaRepository, que proporciona métodos
 * básicos para acceder a la base de datos relacionales utilizando JPA (Java
 * Persistence API). La entidad administrador es la entidad gestionada por esta
 * capa y Integer es el tipo de datos del identificador de la entidad
 * Administrador en la base de datos.
 * 
 * No se proporciona ninguna implementación explícita para los métodos CRUD, ya
 * que Spring Data JPA se encarga de crear la implementación en tiempo de
 * ejecución en función de los nombres de los métodos definidos en esta
 * interfaz. 
 */