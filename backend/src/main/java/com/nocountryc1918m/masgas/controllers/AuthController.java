package com.nocountryc1918m.masgas.controllers;

import com.nocountryc1918m.masgas.auth.entities.AuthResponse;
import com.nocountryc1918m.masgas.auth.entities.LoginRequest;
import com.nocountryc1918m.masgas.auth.entities.RegisterRequest;
import com.nocountryc1918m.masgas.dtos.PagedUserList;
import com.nocountryc1918m.masgas.services.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "auth/", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("login")
    public ResponseEntity<AuthResponse> login (@Valid @RequestBody LoginRequest loginRequest){
        return new ResponseEntity<>(authService.login(loginRequest), HttpStatus.OK);
    }

    @PostMapping("register")
    public ResponseEntity<AuthResponse> register (@Valid @RequestBody RegisterRequest registerRequest){
        return new ResponseEntity<>(authService.register(registerRequest), HttpStatus.CREATED);
    }

    @GetMapping("user/")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<PagedUserList> getAll (@RequestParam(required = false) String role,
                                                 @RequestParam(required = false, defaultValue = "0") Integer page,
                                                 @RequestParam(required = false, defaultValue = "10") Integer size,
                                                 @RequestParam(required = false, defaultValue = "role") String sortBy){
        return new ResponseEntity<>(authService.getAll(role, page, size, sortBy), HttpStatus.OK);
    }


}
