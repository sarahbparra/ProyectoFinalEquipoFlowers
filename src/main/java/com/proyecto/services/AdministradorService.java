package com.proyecto.services;

import java.util.List;

import com.proyecto.entities.Administrador;

public interface AdministradorService {

    public List<Administrador> findAll();

    public Administrador findById(int idAdministrador);

    public void save(Administrador administrador);

    public void deleteById(int idAdministrador);

    public void delete(Administrador administrador);

    /**
     * No es necesario un metodo update, porque el save inserta o actualiza, en
     * dependencia
     * de que el idAdministrador exista o no, es decir, si no existe lo crea, y si
     * existe actualiza
     * la informacion.
     */

}
