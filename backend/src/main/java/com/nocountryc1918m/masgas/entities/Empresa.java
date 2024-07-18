package com.nocountryc1918m.masgas.entities;

import com.nocountryc1918m.masgas.auth.entities.Usuario;
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
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empresa_id")
    private int id;

    @Column(name = "nombre", unique = true)
    private String nombre;
    private String direccion;
    private String telefono;

    @Column(name = "identificadorFiscal", unique = true)
    private String identificadorFiscal;
    private String logotipo;


    @ManyToOne
    @JoinColumn(name = "titular_usuario_id")
    private Usuario titular;
    
}
