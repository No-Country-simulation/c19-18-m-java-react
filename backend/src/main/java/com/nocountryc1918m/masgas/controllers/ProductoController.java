package com.nocountryc1918m.masgas.controllers;

import com.nocountryc1918m.masgas.dtos.ProductoDto;
import com.nocountryc1918m.masgas.exceptions.ProductoNotFound;
import com.nocountryc1918m.masgas.mappers.ProductoMapper;
import com.nocountryc1918m.masgas.services.ProductoService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "products/", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @PostMapping("")
    public ResponseEntity<ProductoDto> createOrUpdate(@Valid @RequestBody ProductoDto productoDto) {


        return new ResponseEntity<>(productoService.createOrUpdate(productoDto), HttpStatus.OK);
    }


    @GetMapping("{id}")
    public ResponseEntity<?> getById(@Valid @PathVariable int id) {

        try {
            return new ResponseEntity<ProductoDto>(productoService.getById(id), HttpStatus.OK);
        } catch (ProductoNotFound e) {

            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);

        }

    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@Valid @PathVariable int id) {
        try {
            productoService.delete(id);
            return new ResponseEntity<String>("Producto eliminado", HttpStatus.OK);
        } catch (ProductoNotFound e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}