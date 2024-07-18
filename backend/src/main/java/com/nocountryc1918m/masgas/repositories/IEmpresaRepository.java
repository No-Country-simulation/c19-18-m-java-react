package com.nocountryc1918m.masgas.repositories;

import com.nocountryc1918m.masgas.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmpresaRepository extends JpaRepository<Empresa, Integer> {
    boolean existsByNombre(String nombre);
    boolean existsByIdentificadorFiscal(String identificadorFiscal);
}
