package com.proyecto.controllers;

import java.lang.ProcessBuilder.Redirect;
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

import com.proyecto.entities.Pedido;
import com.proyecto.services.PedidoService;



@Controller
@RequestMapping("/pedido")

public class PedidoController {

    private static final Logger LOG = Logger.getLogger("PedidoController");

    @Autowired
    private PedidoService pedidoService;


    /* El metodo siguiente devuelve un listado de pedidos */
    @GetMapping("/listar")
    public ModelAndView listar() {
        List<Pedido> pedidos = pedidoService.findAll();
        ModelAndView mav = new ModelAndView("views/listarPedidos");
        mav.addObject("pedidos", pedidos);

        return mav;
    }

    // /**
    //  * Muestra el formulario de alta de 
    //  */
    // @GetMapping("/frmAltaEmpleado")
    // public String formularioAltaEmpleado(Model model) {
    //     List<Departamento> departamento = departamentoService.findAll();
    //     Empleado empleado = new Empleado();
    //     model.addAttribute("empleado", empleado);
    //     model.addAttribute("departamento", departamento);

    //     return "views/formularioAltaEmpleado";
    // }

    // /**
    //  * Metodo que recibe los datos procedentes de los controles del formulario
    //  */
    // @PostMapping("/altaModificacionEmpleado")
    // public String altaEmpleado(@ModelAttribute Empleado empleado,
    //         @RequestParam("numerosTelefonos") String telefonosRecibidos,
    //         @RequestParam("listadoCorreos") String correosRecibidos) {
    //     LOG.info("telefonos recibidos: " + telefonosRecibidos);
    //     LOG.info("correos recibidos: " + correosRecibidos);

    //     empleadoService.save(empleado);
    //     List<String> listadoNumerosTelefonos = null;
    //     if (telefonosRecibidos != null) {
    //         String[] arrayTelefonos = telefonosRecibidos.split(";");
    //         listadoNumerosTelefonos = Arrays.asList(arrayTelefonos);
    //     }
    //     if (listadoNumerosTelefonos != null) {
    //         telefonoService.deleteByEmpleado(empleado);
    //         listadoNumerosTelefonos.stream().forEach(n -> {
    //             Telefono telefonoObject = Telefono
    //                     .builder()
    //                     .numero(n)
    //                     .empleado(empleado)
    //                     .build();
    //             telefonoService.save(telefonoObject);
    //         });
    //     }
    //     // correos
    //     List<String> listadoCorreos = null;
    //     if (correosRecibidos != null) {
    //         String[] arrayCorreos = correosRecibidos.split(";");

    //         listadoCorreos = Arrays.asList(arrayCorreos);
    //     }
    //     if (listadoCorreos != null) {
    //         correoService.deleteByEmpleado(empleado);
    //         listadoCorreos.stream().forEach(c -> {
    //             Correo correoObject = Correo
    //                     .builder()
    //                     .email(c)
    //                     .empleado(empleado)
    //                     .build();
    //             correoService.save(correoObject);
    //         });

    //     }
    //     return "redirect:/listar";
    // }

    // // Método que borra empleados
    // @GetMapping("/borrar/{id}")
    // public String borrarEmpleado(@PathVariable(name = "id") int idEmpleado) {
    //     empleadoService.deleteById(idEmpleado);
    //     return "redirect:/listar";
    // }

    // // Metodo que te da los detalles del empleado
    // @GetMapping("/detalles/{id}")
    // public String empleadoDetails(@PathVariable(name = "id") int id, Model model) {
    //     Empleado empleado = empleadoService.findById(id);

    //     List<Telefono> telefonos = telefonoService.findByEmpleado(empleado);
    //     List<String> numerosTelefono = telefonos.stream()
    //             .map(t -> t.getNumero())
    //             .toList();
    //     model.addAttribute("telefonos", numerosTelefono);
    //     model.addAttribute("empleado", empleado);

    //     List<Correo> correos = correoService.findByEmpleado(empleado);
    //     List<String> correosCorreos = correos.stream()
    //             .map(c -> c.getEmail())
    //             .toList();
    //     model.addAttribute("correos", correosCorreos);
    //     model.addAttribute("empleado", empleado);
    //     return "views/detalles";
    // }

    // // // Actualizar
    // @GetMapping("/frmActualizar/{id}")
    // public String frmActualizaEmpleado(@PathVariable(name = "id") int idEmpleado,
    //         Model model) {

    //     Empleado empleado = empleadoService.findById(idEmpleado);

    //     List<Telefono> TodosTelefonos = telefonoService.findAll();
    //     List<Telefono> telefonosDelEmpleado = TodosTelefonos.stream()
    //             .filter(telefono -> telefono.getEmpleado().getId() == idEmpleado)
    //             .collect(Collectors.toList());

    //     String numerosDeTelefono = telefonosDelEmpleado.stream()
    //             .map(telefono -> telefono.getNumero())
    //             .collect(Collectors.joining(";"));

    //     List<Correo> TodosCorreo = correoService.findAll();
    //     List<Correo> correosDelEmpleado = TodosCorreo.stream()
    //             .filter(correo -> correo.getEmpleado().getId() == idEmpleado)
    //             .collect(Collectors.toList());

    //     String correoEmpleado = correosDelEmpleado.stream()
    //             .map(correo -> correo.getEmail())
    //             .collect(Collectors.joining(";"));

    //     List<Departamento> departamentos = departamentoService.findAll();

    //     model.addAttribute("empleado", empleado);
    //     model.addAttribute("telefonos", numerosDeTelefono);
    //     model.addAttribute("departamento", departamentos);
    //     model.addAttribute("correos", correoEmpleado);
    //     return "views/formularioAltaEmpleado";
    // }
}
