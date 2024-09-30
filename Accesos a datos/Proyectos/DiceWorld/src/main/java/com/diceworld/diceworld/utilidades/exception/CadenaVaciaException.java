package com.diceworld.diceworld.utilidades.exception;

/**
 * Se recibe una cadena vacía no esperada
 */
public class CadenaVaciaException extends RuntimeException{

    public CadenaVaciaException (String mensaje){
        super (mensaje);
    }
}
