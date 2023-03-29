package com.proyecto.entities;
import java.io.Serializable;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vendedores")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Vendedor implements Serializable{ 
    
    private static final long serialVersionUID = 1L;
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //Los campos de Vendedor van a ser nombre, apellidos,dirección del local, telefono y correo
    private int id;
    private String nombre;
    private String apellidos;
    private String telefonoEmpresa;
    private String correo;
    private String direccionLocal;

    @OneToMany (fetch = FetchType.EAGER, 
    cascade =CascadeType.PERSIST, mappedBy = "vendedor")
    private List<Comprador> compradores;

}

