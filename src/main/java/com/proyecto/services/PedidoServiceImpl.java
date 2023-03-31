package com.proyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.dao.PedidoDao;
import com.proyecto.entities.Pedido;

// Service para indicar que es un servicio y busca los beans
@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoDao pedidoDao;
    
    @Override
    public List<Pedido> findAll() {
        return pedidoDao.findAll(); 
    }

    @Override
    public Pedido findById(int idPedido) {
        return pedidoDao.findById(idPedido).get(); 
    }

    @Override
    public void save(Pedido pedido) {
        pedidoDao.save(pedido);
    }

    @Override
    public void deleteById(int idPedido) {
        pedidoDao.deleteById(idPedido);
    }

    @Override
    public void delete(Pedido pedido) {
        pedidoDao.delete(pedido);
    }
  
    
}
