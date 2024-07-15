package com.nocountryc1918m.masgas.auth.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public enum Role {
    USER(
            Set.of(
                    Permission.READ_ALL
            )
    ),
    ADMIN(
            Set.of(
                    Permission.READ_ALL
            )
    );

    @Getter
    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities(){
        List<SimpleGrantedAuthority> auths = getPermissions()
                .stream()
                .map(permision -> new SimpleGrantedAuthority(permision.getPermission()))
                .collect(Collectors.toList());
        auths.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
        return  auths;
    }
}