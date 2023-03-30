
package com.proyecto.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.entities.Proveedor;



@Repository

public interface ProveedorDao extends JpaRepository <Proveedor, Integer> { 
    
}
