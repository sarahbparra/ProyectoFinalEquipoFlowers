package com.proyecto.entities;
import java.io.Serializable;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "proveedores")

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Proveedor implements Serializable{
    
    private static final long serialVersionUID = 1L; 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 

    private int id; 

    private String nombre; 
    private String primerApellido; 
    private String segundoApellido; 

    private String telefono; 
    private String correo; 

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "proveedor")
    private List<Comprador> compradores; //Un proveedor/vendedor puede tener muchos compradores/clientes
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST) 
    private Administrador administrador; 

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "proveedor") 
    private List<Producto> productos; //Un proveedor puede "vender" muchos productos




    //Los campos de Vendedor van a ser nombre, apellidos,dirección del local, telefono y correo
    // private int id;
    // private String nombre;
    // private String apellidos;
    // private String telefonoEmpresa;
    // private String correo;
    // private String direccionLocal;

}
