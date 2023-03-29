package com.proyecto.services;

import java.util.List;

import com.proyecto.entities.Comprador;

public interface CompradorService {
    
    public List<Comprador> findAll(); 
    public Comprador findById(int idComprador); 
    public void save(Comprador comprador); 
    public void deleteById(int idComprador); 
    public void delete(Comprador comprador); 
    public Comprador findByIdPedido (int idPedido); 

}
