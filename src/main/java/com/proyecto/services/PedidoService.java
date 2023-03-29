package com.proyecto.services;

import java.util.List;


import com.proyecto.entities.Pedido;

public interface PedidoService {
    public List<Pedido> findAll(); 
    public Pedido findById(int idPedido); 
    public void save(Pedido pedido); 
    public void deleteById(int idPedido); 
    public void delete(Pedido pedido);     
}
