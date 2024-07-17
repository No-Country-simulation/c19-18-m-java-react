package com.nocountryc1918m.masgas.exceptions.types;

public class ConflictException extends RuntimeException{
    private static final String DESCRIPTION = "Conflict Exception (409)";
    public ConflictException (String detail) { super(DESCRIPTION + ". " + detail); }
}
