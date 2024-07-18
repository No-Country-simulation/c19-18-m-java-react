package com.nocountryc1918m.masgas.controllers;

import com.nocountryc1918m.masgas.dtos.EmpresaDto;
import com.nocountryc1918m.masgas.exceptions.EmpresaNotFound;
import com.nocountryc1918m.masgas.services.EmpresaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class EmpresaController {
    @Autowired
    private EmpresaService empresaService;

    @GetMapping
    public ResponseEntity<List<EmpresaDto>> getAllEmpresas() {
        return new ResponseEntity<>(empresaService.getAllEmpresas(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmpresaById(@Valid @PathVariable int id) {
        try {
            return new ResponseEntity<EmpresaDto>(empresaService.getEmpresaById(id), HttpStatus.OK);
        } catch (EmpresaNotFound e) {

            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);

        }
    }


    @PostMapping
    public ResponseEntity<EmpresaDto> createOrUpdate(@Valid @RequestBody EmpresaDto empresaDto) {
        try {
            return new ResponseEntity<>(empresaService.createOrUpdate(empresaDto), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmpresa(@PathVariable int id) {
        try{
            empresaService.deleteEmpresa(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}

