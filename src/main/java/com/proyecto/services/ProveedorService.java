package com.proyecto.services;
import java.util.List;
import com.proyecto.entities.Proveedor;

public interface ProveedorService {
    
     public List<Proveedor> findAll(); //dame todos los vendedores por si hubiese mas de uno(no creo) 
     public Proveedor findById(int idProveedor); //buscame el vendedor por su id 
     public void save(Proveedor proveedor);   
     public void deleteById(int idProveedor);
}
