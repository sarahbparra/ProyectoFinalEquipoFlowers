package com.proyecto.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.entities.Proveedor;

public interface ProveedorDao extends JpaRepository<Proveedor, Integer>{
    
    
}
