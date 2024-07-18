package com.nocountryc1918m.masgas.services;

import com.nocountryc1918m.masgas.dtos.EmpresaDto;
import com.nocountryc1918m.masgas.mappers.EmpresaMapper;
import com.nocountryc1918m.masgas.repositories.IEmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nocountryc1918m.masgas.exceptions.EmpresaNotFound;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    private IEmpresaRepository empresaRepository;

    EmpresaMapper empresaMapper = new EmpresaMapper();

    public List<EmpresaDto> getAllEmpresas() {
        return empresaMapper.toDtoList(empresaRepository.findAll()) ;
    }

    public EmpresaDto getEmpresaById(int id) {
        return empresaMapper.toDto(empresaRepository.findById(id).orElseThrow(EmpresaNotFound::new));
    }

    public EmpresaDto createOrUpdate(EmpresaDto empresaDto) {
        return empresaMapper.toDto(empresaRepository.save(empresaMapper.toEntity(empresaDto)));
    }

    public void deleteEmpresa(int id) {
        if (empresaRepository.existsById(id)) {
            empresaRepository.deleteById(id);
        } else {
            throw new EmpresaNotFound();
        }
    }
}

