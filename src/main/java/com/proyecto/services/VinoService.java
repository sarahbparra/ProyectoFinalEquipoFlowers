package com.proyecto.services;

import java.util.List;

import com.proyecto.entities.Vino;

public interface VinoService {

    public List<Vino> findAll(); 
    public Vino findById(int id); 
    public void save(Vino vino); 
    public void deleteById(int id); 
    public void delete(Vino vino);     
    
}
