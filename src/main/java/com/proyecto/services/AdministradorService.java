package com.proyecto.services;

import java.util.List;

import com.proyecto.entities.Administrador;

public interface AdministradorService {

    List<Administrador> findAll(); //He creado este metodo en esta clase para que no me diese error en el mainController
    
}
