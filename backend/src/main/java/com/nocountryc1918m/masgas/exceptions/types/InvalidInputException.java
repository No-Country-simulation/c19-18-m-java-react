package com.nocountryc1918m.masgas.exceptions.types;

public class InvalidInputException extends RuntimeException{
    private static final String DESCRIPTION = "Field Invalid Exception";
    public InvalidInputException (String detail) { super(DESCRIPTION + ". " + detail); }
}
