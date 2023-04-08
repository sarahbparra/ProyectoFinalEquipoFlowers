package com.proyecto.controllers;

import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
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
import org.springframework.web.servlet.view.RedirectView;

import com.proyecto.entities.Comprador;
import com.proyecto.entities.Pedido;
import com.proyecto.entities.Producto;
import com.proyecto.services.CompradorService;
import com.proyecto.services.PedidoService;
import com.proyecto.services.ProductoService;



@Controller
@RequestMapping("/pedido")

public class PedidoController {

    private static final Logger LOG = Logger.getLogger("PedidoController");

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private CompradorService compradorService;

    @Autowired
    private ProductoService productoService;


    /* El metodo siguiente devuelve un listado de pedidos */
    @GetMapping("/listar")
    public ModelAndView listar() {
        List<Pedido> pedidos = pedidoService.findAll();
        ModelAndView mav = new ModelAndView("views/listarPedidos");
        mav.addObject("pedidos", pedidos);

        return mav;
    }

    /**
     * Muestra el formulario de alta de un pedido
     */
    @GetMapping("/frmAltaPedido")
    public String formularioAltaPedido(Model model) {
        List<Comprador> compradores = compradorService.findAll();
        List<Producto>productos = productoService.findAll();
        model.addAttribute("pedido", new Pedido());
        model.addAttribute("compradores", compradores);
        model.addAttribute("productos", productos);
        return "views/formularioAltaPedido";
    }

    /**
     * Metodo que recibe los datos procedentes de los controles del formulario
     */
    @PostMapping("/altaModificacionPedido")
    public String altaPedido(@ModelAttribute Pedido pedido,
            @RequestParam("productos") int[] productosRecibidos) {
        LOG.info("productos recibidos: " + productosRecibidos);

        List<Producto> productos = new ArrayList<>();
        for(int productoId : productosRecibidos){
            productos.add(productoService.findById(productoId));
        }
        pedido.setProductos(productos);
        pedidoService.save(pedido);
 
        return "redirect:/pedido/listar";
    }

    // // Método que borra pedidos
    @GetMapping("/borrar/{id}")
    public String borrarPedido(@PathVariable(name = "id") int idPedido) {
        pedidoService.deleteById(idPedido);
        return "redirect:/listar";
    }

    //Metodo que te da los detalles del pedido
        @GetMapping("/detalles/{id}")
        public String pedidoDetails(@PathVariable(name = "id") int id, Model model) {
        Pedido pedido = pedidoService.findById(id);

        List<Producto> productos = productoService.findByPedido(pedido);
        List<String> codProductos = productos.stream()
                .map(p -> p.getCodigoProducto())
                .toList();
        model.addAttribute("codProductos", codProductos);
        model.addAttribute("pedido", pedido);

        return "views/detallePedido";
    }

    // // // Actualizar
    @GetMapping("/frmActualizar/{id}")
    public String frmActualizarPedido(@PathVariable(name = "id") int idPedido,
            Model model) {

        Pedido pedido = pedidoService.findById(idPedido);

        List<Comprador> compradores = compradorService.findAll();
        List<Producto> allProductos = productoService.findAll();
        //List<Producto> productosSel = productoService.findByPedido(pedido);

        model.addAttribute("pedido", pedido);
        model.addAttribute("compradores", compradores);
        model.addAttribute("productos", allProductos);
        //model.addAttribute("productosSel", productosSel);


        return "views/formularioAltaPedido";
    }
}
