package com.proyecto.services;

import java.util.List;

import com.proyecto.entities.Administrador;

/**
 * Interfaz que define los servicios para la entidad Administrador.
 */
public interface AdministradorService {

    /**
     * Este método oObtiene todos los administradores:
     *
     * @return Lista de administradores.
     */
    public List<Administrador> findAll();

    /**
     * Método que busca un administrador por su identificador.
     *
     * @param idAdministrador Identificador del administrador a buscar.
     * @return Administrador con el identificador especificado.
     */
    public Administrador findById(int idAdministrador);

    /**
     * Guarda un administrador en la base de datos.
     *
     * @param administrador Administrador a guardar.
     */
    public void save(Administrador administrador);

    /**
     * Elimina un administrador de la base de datos por su identificador.
     *
     * @param idAdministrador Identificador del administrador a eliminar.
     */
    public void deleteById(int idAdministrador);

    /**
     * Elimina un administrador de la base de datos.
     *
     * @param administrador Administrador a eliminar.
     */
    public void delete(Administrador administrador);

    /**
     * No es necesario un metodo update, porque el save inserta o actualiza, en
     * dependencia de que el idAdministrador exista o no, es decir, si no existe lo
     * crea, y si
     * existe actualiza la informacion.
     */

}