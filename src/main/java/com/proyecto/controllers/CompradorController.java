package com.proyecto.controllers;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.proyecto.entities.Administrador;
import com.proyecto.entities.Comprador;
import com.proyecto.services.AdministradorService;
import com.proyecto.services.CompradorService;

@Controller
@RequestMapping("/compradores")

public class CompradorController {

    private static final Logger LOG = Logger.getLogger("CompradorController");  


    @Autowired
    private CompradorService compradorService; 

    @Autowired
    private AdministradorService administradorService; 

    //Método que devuelva un listado de compradores. 

    //http://localhost:8080/compradores/listar
    @GetMapping("/listar")
    public ModelAndView listarCompradores(){

        List<Comprador> compradores = compradorService.findAll(); 

        ModelAndView mav = new ModelAndView("views/listarCompradores"); 

        mav.addObject("compradores", compradores); 

        return mav; 
    }


    //Método para poder meter datos sobre compradores 
    //Debería tener en cuenta aquí a los administradores? 
    //Podría hacer un desplegable en el que se le asigne un administrador 

    @GetMapping("/frmAltaComprador")
    public String formularioAltaComprador(Model model){

        List<Administrador> administradores = administradorService.findAll(); 

        Comprador comprador = new Comprador(); 

        model.addAttribute("comprador", comprador); 
        model.addAttribute("administradores", administradores); 

        return "views/formularioAltaComprador"; 
    }

    //Método para que los datos del comprador se almacenen 



    
}
