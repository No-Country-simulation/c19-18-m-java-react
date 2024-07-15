package com.nocountryc1918m.masgas.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductoEmpresa {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "producto_empresa_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    private double precio;
    private int disponibles;
    private String imagen;

}
