package com.proyecto;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.proyecto.entities.Administrador;
import com.proyecto.entities.Comprador;
import com.proyecto.entities.Comprador.Genero;
import com.proyecto.services.AdministradorService;
import com.proyecto.services.CompradorService;
import com.proyecto.services.ProductoService;

@SpringBootApplication
public class ProyectoFinalEquipoFlowersApplication implements CommandLineRunner {

	@Autowired
	private AdministradorService administradorService;

	@Autowired
	private ProductoService productoService;

	@Autowired
	private CompradorService compradorService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoFinalEquipoFlowersApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/**
		 * Método para agregar registros de muestra para administrador (crear y añadir
		 * administradores),
		 * Empleado (crear y añadir empleados) y Telefono (crear y añadir
		 * telefonos):
		 */

		administradorService.save(Administrador.builder()
				.nombre("Celia Cava Ruíz")
				.correo("admin1@gmail.com")
				.telefono("telAdmin1")
				.build());

		administradorService.save(Administrador.builder()
				.nombre("Sarah Benabidi Parra")
				.correo("admin2@gmail.com")
				.telefono("telAdmin2")
				.build());

		administradorService.save(Administrador.builder()
				.nombre("Irene González Moreno")
				.correo("admin2@gmail.com")
				.telefono("telAdmin2")
				.build());

		administradorService.save(Administrador.builder()
				.nombre("Zineb Afkir")
				.correo("admin2@gmail.com")
				.telefono("telAdmin2")
				.build());

		// Registros agregados para Comprador.

		compradorService.save(Comprador.builder()
				.id(1)
				.nombre("María")
				.primerApellido("García")
				.segundoApellido("López")
				.fechaNacimiento(LocalDate.of(2000, Month.APRIL, 6))
				.genero(Genero.MUJER)
				.telefono("618 331 251")
				.correo("mariaGL@gmail.com")
				.administrador(administradorService.findById(1))
				.build());

		compradorService.save(Comprador.builder()
				.id(2)
				.nombre("Juana")
				.primerApellido("García")
				.segundoApellido("López")
				.fechaNacimiento(LocalDate.of(1998, Month.APRIL, 6))
				.genero(Genero.MUJER)
				.telefono("666 333 999")
				.correo("juanaGL@gmail.com")
				.administrador(administradorService.findById(1))
				.build());
	}
}
