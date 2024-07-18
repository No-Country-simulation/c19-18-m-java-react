package com.nocountryc1918m.masgas.exceptions;

public class EmpresaNotFound extends RuntimeException{
    public EmpresaNotFound(String message) {
        super(message);
    }

    public EmpresaNotFound(){
        super("Empresa no encontrada");
    }
}


