package com.proyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.dao.ProveedorDao;
import com.proyecto.entities.Proveedor;

@Service

public class ProveedorServiceImpl implements ProveedorService{
    

    @Autowired
    private ProveedorDao proveedorDao;

    @Override
    public List<Proveedor> findAll() {
        
        return proveedorDao.findAll(); 
    }

    @Override
    public Proveedor findById(int idProveedor) {
        
        return proveedorDao.findById(idProveedor).get(); 
    }

    @Override
    public void save(Proveedor proveedor) {
        
        proveedorDao.save(proveedor); 
    }

    @Override
    public void deleteById(int idProveedor) {
        
        proveedorDao.deleteById(idProveedor);
    }

    @Override
    public void delete(Proveedor proveedor) {
    
        proveedorDao.delete(proveedor);
    } 

    
}
