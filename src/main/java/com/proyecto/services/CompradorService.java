package com.proyecto.services;

import java.util.List;

import com.proyecto.entities.Comprador;

public interface CompradorService {
    
    public List<Comprador> findAll(); 
    public Comprador findById(int idComprador); 
    public void save(Comprador comprador); 
    public void deleteById(int idEstudiante); 
    public void delete(Comprador comprador); 

}
