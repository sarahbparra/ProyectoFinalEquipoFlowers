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
import com.proyecto.entities.Comprador;
import com.proyecto.entities.Producto;
import com.proyecto.entities.Proveedor;
import com.proyecto.services.AdministradorService;
//import com.proyecto.services.AdministradorService;
import com.proyecto.services.CompradorService;
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

    @Autowired
    private CompradorService compradorService;
    

    //El siguiente metodo devuelve un listado de Proveedores

    @GetMapping("/listarProveedor") 
    public ModelAndView listar(){ 
       
        List<Proveedor> proveedores = proveedorService.findAll();
        
        ModelAndView mav = new ModelAndView("views/listarProveedor");
        
        mav.addObject("proveedores",proveedores);

        return mav; 
    }

    
    // Metodo para mostrar el formulario de alta de un proveedor,es decir, Crear un proveedor 
     

     @GetMapping("/frmAltaProveedor") // aqui es el nombre de la url que va a resoponder y le damos el nombre que queramos
     public String formularioAltaProveedor(Model model){

     List<Administrador> administradores = administradorService.findAll();

      Proveedor proveedor = new Proveedor();

        model.addAttribute("proveedor",proveedor);
        model.addAttribute("administradores", administradores); // aqui esta esperando recibir 
       // "administradores" de la view FormularioAltaProveedor <option th:each="administrador: ${dadministradores}" 

        return "views/FormularioAltaProveedor"; // esto hace referencia a la views creada en templates

     }

      

        /**
         * Metodo que recibe los datos procedentes de los controladores del formulario 
         *
         */

         @PostMapping("/altaModificacionProveedor") 
        public String altaProveedor(@ModelAttribute Proveedor proveedor,
                      @RequestParam(name ="productos") String productosDelProveedor,
                      @RequestParam(name ="compradores") String compradoresDelProveedor){

            LOG.info("Productos Del Proveedor: " + productosDelProveedor);
 
            proveedorService.save(proveedor); //guarda el proveedor en la bbdd 


            List<String> listadoProductos = null;
            if(productosDelProveedor != null) {
            String[] arrayProductos = productosDelProveedor.split(";"); 
         
            listadoProductos = Arrays.asList(arrayProductos);
            }

  
             if(listadoProductos!= null) {
              productoService.deleteByProveedor(proveedor);
              listadoProductos.stream().forEach(p->{
                     Producto productoObject = Producto.builder().codigoProducto(p).proveedor(proveedor).build();

                     productoService.save(productoObject);
                });
                
            // LOG.info("Compradores Del Proveedor: " + compradoresDelProveedor);

            // proveedorService.save(proveedor);

            // List<String> listadoCompradores = null;
            // if (compradoresDelProveedor != null) {
            //     String[] arrayCompradores = compradoresDelProveedor.split(";");

            //     listadoCompradores = Arrays.asList(arrayCompradores);
            // }

            // if (listadoCompradores != null) {
            //   compradorService.deleteByProveedor(proveedor);
            //   listadoCompradores.stream().forEach(c -> {
            //     Comprador compradorObject = Comprador.builder()
            //                 .nombre(c)
            //                 .proveedor(proveedor)
            //                 .build();

            //       compradorService.save(compradorObject);

            //     });

            }
             
            
             
            return "redirect:/listarProveedor"; 
        }
     


/*
 * Metodo para actualizar los datos de un proveedor dado su id
 */

       @GetMapping("/frmActualizar/{id}")
       public String frmactualizaProveedor(@PathVariable(name ="id") int idProveedor, Model model){ 

        Proveedor proveedor= proveedorService.findById(idProveedor);
        
        List<Producto> todosProductos = productoService.findAll(); // findAll devuelve una lista de todos los productos de mi Proveedor
        
    
        List<Producto> produtcosDelProveedor = todosProductos.stream().filter(p->p.getProveedor().getId() == idProveedor)
        .collect(Collectors.toList()); 
    
        String prdctos = produtcosDelProveedor.stream().map(t->t.getCodigoProducto()).collect(Collectors.joining(";"));
        
        model.addAttribute("proveedor", proveedor);
        model.addAttribute("productos", prdctos);

    
        //Compradores

        List<Comprador> todosCompradores = compradorService.findAll();
        

        List<Comprador> compradoresDelProveedor = todosCompradores
       .stream()
       .filter(c -> c.getProveedor().getId() == idProveedor)
       .collect(Collectors.toList());



        String cpradores = compradoresDelProveedor.stream().map(c -> c.getNombre())
               .collect(Collectors.joining(";"));

        model.addAttribute("compradores", cpradores);


        List<Administrador> administradores =administradorService.findAll();
        
        model.addAttribute("administradores", administradores);

        return "views/FormularioAltaProveedor";

        
       }

       // Metodo para borrar un proveedor pasado su id
       @GetMapping("/borrar/{id}")
       public String borrarProveedor(@PathVariable(name="id") int idProveedor){

        proveedorService.delete(proveedorService.findById(idProveedor));
         
         return "redirect:/listarProveedor";

       }

      
           
    // Metodo que nos de los detalles de un proveedor
    @GetMapping("/detalles/{id}")
    public String detallesProveedorString(@PathVariable(name = "id") int id, Model model) {

        Proveedor proveedor = proveedorService.findById(id);

        List<Producto> productos = productoService.findByProveedor(proveedor);
        List<String> numerosProducto = productos.stream().map(t -> t.getCodigoProducto()).toList();

        // List<Comprador> compradores = compradorService.findByProveedor(proveedor);
        // List<String> nComprador = compradores.stream().map(c -> c.getNombre()).toList();

        model.addAttribute("productos", numerosProducto);
        //model.addAttribute("compardores", nComprador);
        model.addAttribute("proveedor", proveedor);

       
        return "views/detallesProveedor"; // esto hace referencia a la views llamada  detalleEmpleado
        //creada en templates
    }
}
    



