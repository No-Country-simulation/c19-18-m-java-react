package com.nocountryc1918m.masgas.mappers;

import com.nocountryc1918m.masgas.auth.entities.Usuario;
import com.nocountryc1918m.masgas.dtos.UserReadDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    /*
    int id;
    String nombre;
    String apellido;
    String telefono;
    String email;
    String password;
    Role role;
    boolean activo;
    LocalDateTime creado;
    LocalDateTime modificado;
     */
    public UserReadDto toReadDto(Usuario u){
        return UserReadDto.builder()
                .id(u.getId())
                .nombre(u.getNombre())
                .apellido(u.getApellido())
                .telefono(u.getTelefono())
                .email(u.getEmail())
                .role(u.getRole())
                .activo(u.isActivo())
                .creado(u.getCreado())
                .modificado(u.getModificado())
                .build();
    }

}
