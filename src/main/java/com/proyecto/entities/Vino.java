package com.proyecto.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vinos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vino extends Producto {
    
        private String nombre;
        private String denominacionOrigen;
        private int anyo;
        private double precio;
        private TipoVino tipo;

        public enum TipoVino {
            TINTO,BLANCO,ROSADO
        }
        

}
