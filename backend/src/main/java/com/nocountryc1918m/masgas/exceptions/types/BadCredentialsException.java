package com.nocountryc1918m.masgas.exceptions.types;

import lombok.Data;

@Data
public class BadCredentialsException extends RuntimeException{
    private static final String DESCRIPTION = "Error de credenciales";
    public BadCredentialsException(String detail) { super(DESCRIPTION + " " + detail); }

}
