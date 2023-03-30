package com.proyecto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.proyecto.entities.Administrador;
import com.proyecto.services.AdministradorService;

@SpringBootApplication
public class ProyectoFinalEquipoFlowersApplication implements CommandLineRunner {

	@Autowired
	private AdministradorService administradorService;

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
				.nombre("Admin1")
				.correo("admin1@gmail.com")
				.telefono("telAdmin1")
				.build());

		administradorService.save(Administrador.builder()
				.nombre("Admin2")
				.correo("admin2@gmail.com")
				.telefono("telAdmin2")
				.build());
	}
}
