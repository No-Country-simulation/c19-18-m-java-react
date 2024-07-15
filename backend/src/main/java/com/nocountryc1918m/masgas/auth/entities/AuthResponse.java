package com.nocountryc1918m.masgas.auth.entities;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AuthResponse {
    String token;
}
