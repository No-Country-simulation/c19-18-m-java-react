package com.nocountryc1918m.masgas.mappers;

import com.nocountryc1918m.masgas.dtos.ProductoDto;
import com.nocountryc1918m.masgas.entities.Producto;

import java.util.List;
import java.util.Set;

public class ProductoMapper {

    public Producto toEntity(ProductoDto productoDto) {
        Producto entity = new Producto();
        entity.setId(productoDto.getId());
        entity.setNombre(productoDto.getNombre());
        entity.setTipoGas(productoDto.getTipoGas());
        entity.setTipoEnvase(productoDto.getTipoEnvase());
        entity.setDiametro_mm(productoDto.getDiametro_mm());
        entity.setAltura_mm(productoDto.getAltura_mm());
        return entity;
    }

    public ProductoDto toDto(Producto producto) {
        ProductoDto dto = new ProductoDto();
        dto.setId(producto.getId());
        dto.setNombre(producto.getNombre());
        dto.setTipoGas(producto.getTipoGas());
        dto.setTipoEnvase(producto.getTipoEnvase());
        dto.setDiametro_mm(producto.getDiametro_mm());
        dto.setAltura_mm(producto.getAltura_mm());
        return dto;
    }


    public List<ProductoDto> toDtoList(List<Producto> productos) {
        if(productos == null) return null;
        return productos.stream().map(this::toDto).toList();
    }
}
