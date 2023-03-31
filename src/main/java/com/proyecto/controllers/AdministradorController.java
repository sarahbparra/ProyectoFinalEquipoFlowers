package com.proyecto.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.proyecto.entities.Administrador;
import com.proyecto.services.AdministradorService;
import com.proyecto.services.CompradorService;

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

    @Autowired
    private CompradorService compradorService;

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
     * Metodo que recibe los datos procedentes de los controladores del formulario y
     * se muestre el último creado
     */
    @PostMapping("/altaModificacionAdministrador")
    public String altaModificacionAdministrador(@ModelAttribute Administrador administrador,
            @RequestParam(name = "compradores") String compradoresRecibidos) {

        // gracias al log nos da un mensaje de comprobación antes de procesar la
        // información. Es una buena práctica de programación hacer esta comprobación
        // previa
        LOG.info("compradores recibidos: " + compradoresRecibidos);

        // Se guarda el Administrador para despues poder acceder a él a la hora de
        // meterle los compradores
        administradorService.save(administrador);

        List<String> listadoNumeroscomprador = null; // la declaramos fuera,para poder utilizarla en varios sitios. Y le
                                                     // asignamos null, porque dentro de un método siempre hay que
                                                     // inicializarla (asignarle valor) para que funcione

        // No queremos guardar compradores si no los hay, por eso ponemos el if
        if (compradoresRecibidos != null) {
            String[] arraycompradores = compradoresRecibidos.split(";"); // separa el array cada vez que encuentra un ;,
            // podría pedirle que separase cada vez que
            // encuentre un espacio
            // Convertimos este array en una colección para luego pasarlo a flujo y trabajar
            // con ese flujo:
            listadoNumeroscomprador = Arrays.asList(arraycompradores);
        }

        // // si sí hay compradores, el flujo lo recorremos e introducimos
        // if (listadoNumeroscomprador != null) {
        //     compradorService.deleteByAdministrador(administrador);
        //     listadoNumeroscomprador.stream().forEach(n -> {
        //         Comprador compradorObject = Comprador.builder()
        //                 // aqui poner todas las variables de comprador?
        //                 .nombre(n)
        //                 .primerApellido(n)
        //                 .segundoApellido(n)
        //                 .correo(n)
        //                 .genero(null)
        //                 .administrador(administrador)
        //                 .build();

        //         compradorService.save(compradorObject);
        //     });
        // }

        return "redirect:/listar";
    }

    /**
     * CRUD comprador: el administrador tiene que ser capaz de eliminar y actualizar
     * compradores
     */

    /**
     * CRUD compradores: el administrador tiene que ser capaz de eliminar y
     * actualizar compradores
     */

    /**
     * CRUD Producto: el administrador tiene que ser capaz de eliminar y actualizar
     * productos. 
     */
}
