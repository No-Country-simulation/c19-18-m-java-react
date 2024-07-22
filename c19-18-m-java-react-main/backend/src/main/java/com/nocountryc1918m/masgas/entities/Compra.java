package com.nocountryc1918m.masgas.entities;

import com.nocountryc1918m.masgas.auth.entities.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "compra_id")
    private int id;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "comprador_usuario_id")
    private Usuario comprador;

    private String direccionEnvio;
    private String estadoCompra;
    private String formaPago;
    private LocalDateTime fechaCompra;


}
