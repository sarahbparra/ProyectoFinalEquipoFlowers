package com.proyecto.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
    
    @RequestMapping("/bienvenido")
    public String mostrarBienvenida() {
        return "views/bienvenido"; // nombre del archivo HTML sin extensión
    }
    
    @GetMapping("/home")
    public String home() {
        return "views/home";
    }

//     @GetMapping("/listarProveedores")
//   public String listarProveedores() {
//     return "listarProveedores"; //nombre de la vista a devolver
//   }

//   @GetMapping("/listarProductos")
    
//     // otros métodos del controlador
}

