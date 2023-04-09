package com.proyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.dao.ProductoDao;
import com.proyecto.entities.Producto;
import com.proyecto.entities.Proveedor;

@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    private ProductoDao productoDao;

    @Override
    public List<Producto> findAll() {
        return productoDao.findAll();
    }

    @Override
    public Producto findById(int idProducto) {
        return productoDao.findById(idProducto).get();
    }

    @Override
    public void save(Producto producto) {
        productoDao.save(producto);
    }

    @Override
    public void deleteById(int idProducto) {
        productoDao.deleteById(idProducto);
    }

    

    @Override
    public void delete(Producto producto) {
        productoDao.delete(producto);
    }

   

   
    
}
