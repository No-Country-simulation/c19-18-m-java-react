package com.nocountryc1918m.masgas.services;

import com.nocountryc1918m.masgas.dtos.ProductoDto;
import com.nocountryc1918m.masgas.entities.Producto;
import com.nocountryc1918m.masgas.exceptions.ProductoNotFound;
import com.nocountryc1918m.masgas.mappers.ProductoMapper;
import com.nocountryc1918m.masgas.repositories.IProductoRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ProductoService {

    @Autowired
    IProductoRepository productoRepository;

    ProductoMapper productoMapper = new ProductoMapper();


    public ProductoDto createOrUpdate(ProductoDto productoDto) {


        return productoMapper.toDto(productoRepository.save(productoMapper.toEntity(productoDto)));

    }

    public ProductoDto getById(int id) {
        return productoMapper.toDto(productoRepository.findById(id).orElseThrow(ProductoNotFound::new));
    }


    public void delete(int id) {
        if (!productoRepository.existsById(id)) {
            throw new ProductoNotFound();
        }
        productoRepository.deleteById(id);

    }

}
