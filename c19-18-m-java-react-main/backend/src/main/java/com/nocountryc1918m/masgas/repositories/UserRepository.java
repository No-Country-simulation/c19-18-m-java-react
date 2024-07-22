package com.nocountryc1918m.masgas.repositories;

import com.nocountryc1918m.masgas.auth.entities.Role;
import com.nocountryc1918m.masgas.auth.entities.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByEmail (String email);
    Page<Usuario> findByRole(Role role, Pageable pageable);
    Page<Usuario> findByEmailContains(String email, Pageable pageable);

}
