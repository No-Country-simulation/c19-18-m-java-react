package com.nocountryc1918m.masgas.repositories;

import com.nocountryc1918m.masgas.dtos.ProductoDto;
import com.nocountryc1918m.masgas.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface IProductoRepository extends JpaRepository<Producto, Integer> {

    Producto getByTipoGas(String tipoGas);

}
