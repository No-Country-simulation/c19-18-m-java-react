package com.nocountryc1918m.masgas.repositories;

import com.nocountryc1918m.masgas.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoRepository extends JpaRepository<Producto, Integer> {
}
