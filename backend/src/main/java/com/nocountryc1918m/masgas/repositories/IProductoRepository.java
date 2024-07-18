package com.nocountryc1918m.masgas.repositories;

import com.nocountryc1918m.masgas.dtos.ProductoDto;
import com.nocountryc1918m.masgas.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface IProductoRepository extends JpaRepository<Producto, Integer> {

    List<Producto> getByTipoGas(String tipoGas);

    @Query("SELECT p FROM Producto p WHERE p.altura_mm * p.diametro_mm = :volume")
    List<Producto> getByVolume(int volume);
}
