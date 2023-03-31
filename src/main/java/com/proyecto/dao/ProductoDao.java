package com.proyecto.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.entities.Producto;
import com.proyecto.entities.Proveedor;

public interface ProductoDao extends JpaRepository<Producto, Integer>{
    
long deleteByProveedor(Proveedor proveedor);

List<Producto> findByProveedor(Proveedor proveedor);
// List<Producto> findByComprador(Comprador comprador);
// List<Producto> findByPedido(Pedido pedido);

}
