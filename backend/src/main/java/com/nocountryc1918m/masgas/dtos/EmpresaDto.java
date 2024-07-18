package com.nocountryc1918m.masgas.dtos;


import com.nocountryc1918m.masgas.auth.entities.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmpresaDto {

        private int id;

        private String nombre;
        private String direccion;
        private String telefono;
        private String identificadorFiscal;
        private String logotipo;
        private Usuario titular;
}
