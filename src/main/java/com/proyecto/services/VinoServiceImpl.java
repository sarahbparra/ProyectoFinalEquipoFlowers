package com.proyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.dao.VinoDao;
import com.proyecto.entities.Vino;



// Service para indicar que es un servicio y busca los beans
@Service
public class VinoServiceImpl implements VinoService {

    @Autowired
    private VinoDao vinoDao;

    @Override
    public List<Vino> findAll() {
        return vinoDao.findAll(); 
    }

    @Override
    public Vino findById(int id) {
        return vinoDao.findById(id).get(); 
        
    }
    @Override
    public void save(Vino vino) {
        vinoDao.save(vino); 

    }

    @Override
    public void delete(Vino vino) {
       vinoDao.delete(vino); 
    }

    @Override
    public void deleteById(int id) {
        vinoDao.deleteById(id);
    }
}