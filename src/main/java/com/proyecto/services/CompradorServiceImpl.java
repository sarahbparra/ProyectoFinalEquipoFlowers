package com.proyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.dao.CompradorDao;
import com.proyecto.entities.Comprador;

//Para buscar los beans de los datos 
@Service

public class CompradorServiceImpl implements CompradorService{

    @Autowired
    private CompradorDao compradorDao; 

    @Override
    public List<Comprador> findAll() {
        
        return compradorDao.findAll(); 
    }

    @Override
    public Comprador findById(int idComprador) {
        
        return compradorDao.findById(idComprador).get(); 
    }

    @Override
    public void save(Comprador comprador) {
        
        compradorDao.save(comprador); 
    }

    @Override
    public void deleteById(int idEstudiante) {
        
        compradorDao.deleteById(idEstudiante);
    }

    @Override
    public void delete(Comprador comprador) {
        
        compradorDao.delete(comprador);
    }
    
}
