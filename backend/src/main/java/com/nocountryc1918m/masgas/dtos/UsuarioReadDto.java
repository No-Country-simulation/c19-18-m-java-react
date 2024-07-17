package com.nocountryc1918m.masgas.dtos;

import com.nocountryc1918m.masgas.auth.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioReadDto {
    int id;
    String nombre;
    String apellido;
    String telefono;
    String email;
    String role;
    Boolean activo;
    LocalDateTime creado;
    LocalDateTime modificado;
}


