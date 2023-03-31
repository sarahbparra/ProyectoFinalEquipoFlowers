package com.proyecto.entities;

import java.io.Serializable;
import java.time.Year;
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
@Table(name = "productos")

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //private String códigoProducto;
    private Tipo tipo;
    public enum Tipo {
        VINO, QUESO
    }
    private String procedencia;
    private String nombre;
    private double precio;
    
    //Propiedades que son exclusivas del vino:
    private double gradosAlcohol;
    private Year anyoCosecha;
    private Envejecimiento envejecimiento;
    public enum Envejecimiento {
        JOVEN, CRIANZA, RESERVA, GRAN_RESERVA
    }
    private Color color;
    public enum Color {
        TINTO, BLANCO, ROSADO
    }
    private double volumen;
    //Propiedades exclusivas del queso;
    private double peso;
    private Maduracion maduracion;
    public enum Maduracion {
        SEMICURADO, CURADO, VIEJO, AÑEJO
    }
    private ProcedenciaLeche procedenciaLeche;
    public enum ProcedenciaLeche{
        VACA, OVJEJA, CABRA, MEZCLA, BUFALA
    }





    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Proveedor proveedor;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "producto")
    List<Pedido> pedidos;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Presentacion presentacion;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Administrador administrador;
    
}
