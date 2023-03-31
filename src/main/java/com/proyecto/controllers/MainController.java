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
import com.proyecto.entities.Producto;
import com.proyecto.entities.Proveedor;
import com.proyecto.services.AdministradorService;
import com.proyecto.services.ProductoService;
import com.proyecto.services.ProveedorService;

@Controller
@RequestMapping("/") 
public class MainController { 
    public static final Logger LOG = Logger.getLogger("MainController");

     @Autowired
    private AdministradorService administradorService; //He creado la interfaz AdministradorSErvice para que no me salte error aqui

    @Autowired
    private ProveedorService proveedorService;

    @Autowired
    private ProductoService productoService;

}