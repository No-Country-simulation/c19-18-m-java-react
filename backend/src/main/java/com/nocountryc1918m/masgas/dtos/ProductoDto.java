package com.nocountryc1918m.masgas.dtos;

import jakarta.validation.constraints.Positive;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDto implements Serializable{


    private int id;
    private String nombre;
    private String tipoGas;
    private String tipoEnvase;
    private int diametro_mm;
    private int altura_mm;
}