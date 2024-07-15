package com.nocountryc1918m.masgas.auth;

import com.nocountryc1918m.masgas.auth.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByEmail (String email);
}
