package com.proyecto.controllers;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.proyecto.entities.Producto;
import com.proyecto.entities.Proveedor;
import com.proyecto.services.ProductoService;
import com.proyecto.services.ProveedorService;

@Controller
@RequestMapping("/productos")
public class ProductoController {
    private static final Logger LOG = Logger.getLogger("ProductoController");

    @Autowired
    private ProductoService productoService;

    @Autowired
    private ProveedorService proveedorService;


/**Método que lista productos */

@GetMapping("/listar")
public ModelAndView listarProductos() {

    List<Producto> productos = productoService.findAll();

    ModelAndView mav = new ModelAndView("views/listarProductos");
    mav.addObject("productos", productos);

    return mav;
}

// /**Método de alta productos */

@GetMapping("/AltaProducto")
public String AltaProducto(Model model) {

    List<Proveedor> proveedores = proveedorService.findAll();
    
    Producto producto = new Producto();

    model.addAttribute("producto", producto);
    model.addAttribute("proveedores", proveedores);

    return "views/formularioAltaProducto";
    
}

//Método que  muestra el formulario que actualiza un procucto:

@GetMapping("/frmActualizar/{id}")
public String frmActualizarProducto(@PathVariable(name = "id") int idProducto, 
Model model) {

   Producto producto = productoService.findById(idProducto);


    List<Proveedor> proveedores = proveedorService.findAll();

    model.addAttribute("producto", producto);
    

    return "views/formularioAltaProducto";
}


//Método que borra productos

@GetMapping("/borrar/{id}")
public String borrarProducto(@PathVariable(name = "id") int idProducto) {

productoService.delete(productoService.findById(idProducto));

return "redirect:/listar";
}
}
