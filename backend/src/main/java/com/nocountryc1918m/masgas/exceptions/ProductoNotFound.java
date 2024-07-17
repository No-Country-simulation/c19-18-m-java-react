package com.nocountryc1918m.masgas.exceptions;

public class ProductoNotFound extends RuntimeException {

    public ProductoNotFound(String message) {
        super(message);
    }

    public ProductoNotFound(){
        super("Producto no encontrado");
    }

}
