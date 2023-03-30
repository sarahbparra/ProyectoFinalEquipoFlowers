package com.proyecto.services;

import java.util.List;

import com.proyecto.entities.Comprador;
import com.proyecto.entities.Pedido;
import com.proyecto.entities.Producto;
import com.proyecto.entities.Proveedor;

public interface ProductoService {
    
    public List<Producto> findAll();
    public Producto findById(int idProducto);
    public void save(Producto producto);
    public void deleteById(int idProducto);
    public void deleteByProveedor(Proveedor proveedor);
    public List<Producto> findByProveedor(Proveedor proveedor);
    // public List<Producto> findByComprador(Comprador comprador);
    // public List<Producto> findByPedido (Pedido pedido);
}
