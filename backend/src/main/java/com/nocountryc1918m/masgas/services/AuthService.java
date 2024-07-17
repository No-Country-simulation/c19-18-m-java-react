package com.nocountryc1918m.masgas.services;

import com.nocountryc1918m.masgas.dtos.UsuarioPagedList;
import com.nocountryc1918m.masgas.dtos.UsuarioReadDto;
import com.nocountryc1918m.masgas.exceptions.types.BadCredentialsException;
import com.nocountryc1918m.masgas.exceptions.types.InvalidInputException;
import com.nocountryc1918m.masgas.exceptions.types.NotFoundException;
import com.nocountryc1918m.masgas.mappers.UserMapper;
import com.nocountryc1918m.masgas.repositories.UserRepository;
import com.nocountryc1918m.masgas.auth.entities.*;
import com.nocountryc1918m.masgas.auth.jwt.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
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
            throw new InvalidInputException("Passwords no coinciden!");
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
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail() , loginRequest.getPassword()));
            UserDetails userDetails = getUsuarioByEmail(loginRequest.getEmail());
            String token = jwtService.generateToken(userDetails);
            return AuthResponse.builder()
                    .token(token)
                    .build();
        } catch (Exception e){
            throw new BadCredentialsException("Login error: "+e.getMessage());
        }
    }
    public Usuario getLoguedUser(HttpHeaders headers) {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return (Usuario) securityContext.getAuthentication().getPrincipal(); // retorna el usuario que envia el jwt
    }

    public UsuarioReadDto deleteUser(Integer id){
        Usuario usuario = getUsuarioById(id);
        userRepository.deleteById(id);
        return userMapper.toReadDto(userRepository.save(usuario));
    }
    public UsuarioReadDto editUser(HttpHeaders headers, Integer id, UsuarioReadDto dto){
        Usuario usuario = getUsuarioById(id); // verificar que existe por id user
        Boolean isAdmin = getLoguedUser(headers).getRole().equals(Role.ADMIN);

        if(isAdmin){ // admin solo puede modificar rol y estado del usuario
            if(dto.getRole() != null) usuario.setRole(Role.valueOf(dto.getRole()));
            if(dto.getActivo() != null) usuario.setActivo(dto.getActivo());
        } else{ // si llego al endpoint, y no es admin,es porque es el usuario y solo puede cambiar sus datos personales
            if(dto.getNombre() != null) usuario.setNombre(dto.getNombre());
            if(dto.getApellido() != null) usuario.setApellido(dto.getApellido());
            if(dto.getTelefono() != null) usuario.setTelefono(dto.getTelefono());

        }
        usuario.setModificado(LocalDateTime.now());
        return userMapper.toReadDto(userRepository.save(usuario));
    }

    public UsuarioReadDto getById(Integer id){
        return userMapper.toReadDto(getUsuarioById(id));
    }
    public Usuario getUsuarioByEmail(String email){
        return userRepository.findByEmail(email).orElseThrow(()-> new NotFoundException("User not found"));
    }

    public Usuario getUsuarioById(Integer id){
        return userRepository.findById(id).orElseThrow(()-> new NotFoundException("User not found"));
    }
    public UsuarioReadDto getByEmail(String email){
        return userMapper.toReadDto(getUsuarioByEmail(email));
    }
    public UsuarioPagedList getAll(String role, String email, Integer page, Integer size, String sortBy) {
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
        } else if(email!= null){
            results = userRepository.findByEmailContains(email, pageable);
        }else {
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
