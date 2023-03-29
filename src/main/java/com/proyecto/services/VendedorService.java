package com.proyecto.services;
import java.util.List;
import com.proyecto.entities.Vendedor;


public interface VendedorService {
    
     public List<Vendedor> findAll(); //dame todos los vendedores por si hubiese mas de uno(no creo) 
     public Vendedor findById(int idVendedor); //buscame el vendedor por su id 
     public void save(Vendedor vendedor);   
     public void deleteById(int idVendedor);
}
