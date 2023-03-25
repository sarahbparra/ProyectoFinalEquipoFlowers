package com.proyecto.entities;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "compradores")

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Comprador implements Serializable{
    
    public static final long serialVersionUID = 1L; 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int id; 

    private String nombre; 
    private String primerApellido; 
    private String segundoApellido; 
    private String correo; 
    private Genero genero; 
    public enum Genero {
        HOMBRE, MUJER, OTRO
    }

   @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST) 
   private  
    
}
