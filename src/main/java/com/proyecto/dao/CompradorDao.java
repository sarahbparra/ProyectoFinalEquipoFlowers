package com.proyecto.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.entities.Comprador;


public interface CompradorDao extends JpaRepository<Comprador, Integer> {

    // Optional<Comprador> findByIdPedido(int idPedido);
    // @Query(value = "select c from Compradoor c left join c.pedidos where p.id = :idPedido")
    // public Comprador findByIdPedido(int idPedido); 

}
