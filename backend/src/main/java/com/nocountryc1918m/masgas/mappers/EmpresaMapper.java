package com.nocountryc1918m.masgas.mappers;

import com.nocountryc1918m.masgas.dtos.EmpresaDto;
import com.nocountryc1918m.masgas.entities.Empresa;

import java.util.List;

public class EmpresaMapper {

    public Empresa toEntity(EmpresaDto empresaDto) {
        Empresa entity = new Empresa();
        entity.setId(empresaDto.getId());
        entity.setNombre(empresaDto.getNombre());
        entity.setDireccion(empresaDto.getDireccion());
        entity.setTelefono(empresaDto.getTelefono());
        entity.setIdentificadorFiscal(empresaDto.getIdentificadorFiscal());
        entity.setLogotipo(empresaDto.getLogotipo());
        entity.setTitular(empresaDto.getTitular());
        return entity;
    }

    public EmpresaDto toDto(Empresa empresa) {
        EmpresaDto dto = new EmpresaDto();
        dto.setId(empresa.getId());
        dto.setNombre(empresa.getNombre());
        dto.setDireccion(empresa.getDireccion());
        dto.setTelefono(empresa.getTelefono());
        dto.setIdentificadorFiscal(empresa.getIdentificadorFiscal());
        dto.setLogotipo(empresa.getLogotipo());
        dto.setTitular(empresa.getTitular());
        return dto;
    }

    public List<EmpresaDto> toDtoList(List<Empresa> empresas) {
        if(empresas == null) return null;
        return empresas.stream().map(this::toDto).toList();
    }
}
