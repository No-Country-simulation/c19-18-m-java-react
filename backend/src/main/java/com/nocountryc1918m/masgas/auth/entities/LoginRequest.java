package com.nocountryc1918m.masgas.auth.entities;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {

    @NotNull(message = "Email no puede ser nulo")
    @Size(min=2, max=30, message = "Email debe tener entre 2 y 30 caracteres")
    String email;

    @NotNull(message = "Password no puede ser nulo")
    @Size(min=2, max=30, message = "Password debe tener entre 2 y 30 caracteres")
    String password;
}
