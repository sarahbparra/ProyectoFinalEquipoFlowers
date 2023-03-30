package com.proyecto.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    //Los metodos Save y delete llevan ademas el @Transactional
    @Override
    @Transactional
    public void save(Proveedor proveedor) {
        proveedorDao.save(proveedor);
    }

    @Override
    @Transactional
    public void deleteById(int idProveedor) {
        proveedorDao.deleteById(idProveedor);
    }

    
    
}
