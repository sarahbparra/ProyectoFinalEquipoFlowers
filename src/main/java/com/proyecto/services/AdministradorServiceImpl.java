package com.proyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.dao.AdministradorDao;
import com.proyecto.entities.Administrador;

/** La anotación @Service sirve para buscar los beans de los datos */
@Service
public class AdministradorServiceImpl implements AdministradorService {

    @Autowired
    private AdministradorDao administradorDao;

    @Override
    public List<Administrador> findAll() {
        return administradorDao.findAll();
    }

    @Override
    public Administrador findById(int idAdministrador) {
        return administradorDao.findById(idAdministrador).get();
    }

    @Override
    public void save(Administrador Administrador) {
        administradorDao.save(Administrador);
    }

    @Override
    public void delete(Administrador Administrador) {
        administradorDao.delete(Administrador);
    }

    @Override
    public void deleteById(int idAdministrador) {
        administradorDao.deleteById(idAdministrador);
    }

    // @Override
    // public Administrador findByIdPedido(int idPedido) {
    // return AdministradorDao.findByIdPedido(idPedido);
    // }

}
