package com.proyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.dao.ProductoDao;
import com.proyecto.entities.Comprador;
import com.proyecto.entities.Pedido;
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
    @Transactional
    public void save(Producto producto) {
        productoDao.save(producto);
    }

    @Override
    @Transactional
    public void deleteById(int idProducto) {
        productoDao.deleteById(idProducto);
    }

    @Override
    @Transactional
    public void deleteByProveedor(Proveedor proveedor) {
        productoDao.deleteByProveedor(proveedor);
    }

    @Override
    public List<Producto> findByProveedor(Proveedor proveedor) {
        return productoDao.findByProveedor(proveedor);
    }

    // @Override
    // public List<Producto> findByPedido(Pedido pedido) {
    //    return productoDao.findByPedido(pedido);
    // }

    // @Override
    // public List<Producto> findByComprador(Comprador comprador) {
    //     return productoDao.findByComprador(comprador);
    // }
    
}
