package com.nocountryc1918m.masgas.services;

import com.nocountryc1918m.masgas.dtos.UsuarioPagedList;
import com.nocountryc1918m.masgas.dtos.UsuarioReadDto;
import com.nocountryc1918m.masgas.mappers.UserMapper;
import com.nocountryc1918m.masgas.repositories.UserRepository;
import com.nocountryc1918m.masgas.auth.entities.*;
import com.nocountryc1918m.masgas.auth.jwt.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AuthService{

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper userMapper;

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

    public UsuarioReadDto getById(Integer id){
        return userMapper.toReadDto(getUsuarioById(id));
    }
    public Usuario getUsuarioById(Integer id){
        Optional<Usuario> u = userRepository.findById(id);
        if (u.isEmpty()) throw new RuntimeException("User not found"); // todo NotFoundException o parecido
        return u.get();
    }
    public UsuarioPagedList getAll(String role, Integer page, Integer size, String sortBy) {
        Page<Usuario> results;
        Sort sort = Sort.by(sortBy);
        Pageable pageable = PageRequest.of(page,size,sort);
        Role searchRole;

        try{
            searchRole = Role.valueOf(role);
        } catch (Exception e){
            searchRole = null;
        }

        if (searchRole != null) {
            results = userRepository.findByRole(searchRole, pageable);
        } else {
            results = userRepository.findAll(pageable);
        }
        Page pagedResults = results.map(entity -> userMapper.toReadDto(entity));

        return UsuarioPagedList.builder()
                .users(pagedResults.getContent())
                .total_results(pagedResults.getTotalElements())
                .results_per_page(size)
                .current_page(page)
                .pages(pagedResults.getTotalPages())
                .sort_by(sortBy)
                .build();
    }

}
