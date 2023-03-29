package com.proyecto.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.entities.Pedido;

public interface PedidoDao extends JpaRepository <Pedido, Integer>{

    }
    

