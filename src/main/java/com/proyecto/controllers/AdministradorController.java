package com.proyecto.controllers;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.proyecto.entities.Administrador;
import com.proyecto.services.AdministradorService;
import com.proyecto.services.CompradorService;

@Controller
@RequestMapping("/administradores")

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
    private static final Logger LOG = Logger.getLogger("AdministradorController");

    @Autowired
    private AdministradorService administradorService;

    @Autowired
    private CompradorService compradorService;

    /** MÉTODOS DE ADMINISTRADOR */

    /** Este metodo devuelve un listado de Administradores: */
    @GetMapping("/listarAdmin")
    public ModelAndView listar() {

        List<Administrador> administradores = administradorService.findAll();

        ModelAndView mav = new ModelAndView("views/listarAdministrador");
        mav.addObject("administradores", administradores);

        return mav;
    }

    
    @GetMapping("/{id}")
    public String findAdministradorById(@PathVariable("id") int id, Model model) {
        Administrador administrador = administradorService.findById(id);
        model.addAttribute("administrador", administrador);
        return "administradores/id";
    }

    /** Metodo de alta de administrador através de un formulario: */
    @GetMapping("/frmAltaAdmin") // aqui es el nombre de la url que va a resoponder y le damos el nombre que
                                 // quieras no tiene porq ser igual que el nombre de abajo
    public String formularioAltaAdministrador(Model model) {

        List<Administrador> administradores = administradorService.findAll();
        Administrador administrador = new Administrador();

        model.addAttribute("administrador", administrador);
        model.addAttribute("administradors", administradores);

        return "formularioAltaAdministrador";
    }

    @PostMapping("/guardar")
    public String saveAdministrador(@ModelAttribute("administrador") Administrador administrador) {
        administradorService.save(administrador);
        return "redirect:/administradores";
    }

    // ME DA FALLO PORQUE FALTA METODO deleteByAdministrador
    // /**
    // * Metodo que recibe los datos procedentes de los controladores del formulario
    // y
    // * se muestre el último creado
    // */
    // @PostMapping("/altaModificacionAdministrador")
    // public String altaModificacionAdministrador(@ModelAttribute Administrador
    // administrador,
    // @RequestParam(name = "compradores") String compradoresRecibidos) {

    // // gracias al log nos da un mensaje de comprobación antes de procesar la
    // // información. Es una buena práctica de programación hacer esta comprobación
    // // previa
    // LOG.info("compradores recibidos: " + compradoresRecibidos);

    // // Se guarda el Administrador para despues poder acceder a él a la hora de
    // // meterle los compradores
    // administradorService.save(administrador);

    // List<String> listadoNumeroscomprador = null; // la declaramos fuera,para
    // poder utilizarla en varios sitios. Y le
    // // asignamos null, porque dentro de un método siempre hay que
    // // inicializarla (asignarle valor) para que funcione

    // // No queremos guardar compradores si no los hay, por eso ponemos el if
    // if (compradoresRecibidos != null) {

    // // Convertimos este array en una colecci
    //
    // listadoNumeroscomprador = Arrays.asList(arraycompradores);
    //
    // }

    // // si sí hay compradores, el flujo lo reco
    // if (listadoNumeroscomprador != null) {
    //
    // compradorService.deleteByAdministrador(administrador);

    // Comprador compradorObject = Comprador.builder()
    // // aqui poner todas las variables de comprador?
    //
    // .primerApellido(n)

    // .correo(n)
    // .genero(nu
    // .administrador(administra

    //
    // );
    //

}
