package com.nocountryc1918m.masgas.auth.entities;

import com.nocountryc1918m.masgas.auth.entities.Role;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "usuarios")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    int id;

    @Column(nullable = false )
    String nombre;

    @Column(nullable = false )
    String apellido;

    @Column(nullable = false )
    String telefono;

    @Column(nullable = false , unique = true)
    String email;

    @Column(nullable = false )
    String password;

    /*
    @ManyToMany
    @JoinTable(
        name = "usuario_role",
        joinColumns = @JoinColumn(name = "usuario_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

     */
    @Enumerated(EnumType.STRING)
    Role role;

    @ColumnDefault("true")
    boolean activo;

    @CreationTimestamp
    LocalDateTime creado;

    @UpdateTimestamp
    LocalDateTime modificado;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return role.getAuthorities();
    }
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

}
