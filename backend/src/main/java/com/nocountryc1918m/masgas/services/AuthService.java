package com.nocountryc1918m.masgas.services;

import com.nocountryc1918m.masgas.auth.UserRepository;
import com.nocountryc1918m.masgas.auth.entities.*;
import com.nocountryc1918m.masgas.auth.jwt.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuthService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtService jwtService;





    public AuthResponse register(RegisterRequest registerRequest) {
        // todo hacer validadores de negocio!!!
        // todo hacer validadores de negocio!!!
        // todo hacer validadores de negocio!!!
        // todo hacer validadores de negocio!!!

        if (! registerRequest.getPassword1().equals(registerRequest.getPassword2())) {
            throw new RuntimeException("Passwords no coinciden!"); // todo InvalidValueException("Passwords no coinciden!");
        }

        Usuario user = new Usuario().builder()
                        .nombre(registerRequest.getNombre())
                        .apellido(registerRequest.getApellido())
                        .telefono(registerRequest.getTelefono())
                        .email(registerRequest.getEmail())
                        .password(passwordEncoder.encode(registerRequest.getPassword1()))
                        .role(Role.USER)
                        .activo(true)
                        .creado(LocalDateTime.now())
                        .modificado(LocalDateTime.now())
                        .build();

        userRepository.save(user);

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(registerRequest.getEmail() , registerRequest.getPassword1()));

        return AuthResponse.builder()
                .token(jwtService.generateToken(user))
                .build();
    }

    public AuthResponse login(LoginRequest loginRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail() , loginRequest.getPassword()));
        UserDetails userDetails = userRepository
                .findByEmail(loginRequest.getEmail())
                .orElseThrow(()->new RuntimeException(("User not found"))); // todo NotFoundException o parecido
        String token = jwtService.generateToken(userDetails);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

}
