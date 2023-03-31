package com.proyecto.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.proyecto.entities.Administrador;
import com.proyecto.services.AdministradorService;

@Controller
@RequestMapping("/")

public class AdministradorController {
    /**
     * el controlador delega la peticion en un metodo que tiene en cuenta el
     * verbo(get, put, delate, post...) del protocolo http utilizado para realizar
     * la peticion
     */

    /**
     * Logger registra todo lo que pasa en esta clase, MainController, para saber
     * todo lo que pasa y poder "hacer un analisis postmortem" si algo va mal
     */
    private static final Logger LOG = Logger.getLogger("MainController");

    /** Métodos correspondientes a Administrador: */
    @Autowired
    private AdministradorService administradorService;

    /** Este metodo devuelve un listado de Administradores: */
    @GetMapping("/listarAdmin")
    public ModelAndView listar() {

        List<Administrador> administradores = administradorService.findAll();

        ModelAndView mav = new ModelAndView("views/listarAdministrador");
        mav.addObject("Administradores", administradores);

        return mav;
    }

    /** Metodo de alta de administrador através de un formulario: */
    @GetMapping("/frmAltaAdmin") // aqui es el nombre de la url que va a resoponder y le damos el nombre que
                                 // quieras no tiene porq ser igual que el nombre de abajo
    public String formularioAltaAdministrador(Model model) {

        
        List<Administrador> administradores = administradorService.findAll();
        Administrador administrador = new Administrador();

        model.addAttribute("administrador", administrador);
        model.addAttribute("administradors", administradores);

        return "views/formularioAltaAdministrador";

    }

   
    /**
     * CRUD comprador: el administrador tiene que ser capaz de eliminar y actualizar
     * compradores
     */

    /**
     * CRUD proveedores: el administrador tiene que ser capaz de eliminar y
     * actualizar proveedores
     */

    /**
     * CRUD Producto: el administrador tiene que ser capaz de eliminar y actualizar
     * productos. 
     */
}
