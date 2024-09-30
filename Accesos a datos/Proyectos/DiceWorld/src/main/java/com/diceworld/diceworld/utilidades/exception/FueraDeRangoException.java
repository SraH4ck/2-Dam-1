package com.diceworld.diceworld.utilidades.exception;

/**
 * El valor proporcionado está fuera de un determinado rango de valores.
 */
public class FueraDeRangoException extends RuntimeException{
    public FueraDeRangoException (String mensaje){
        super (mensaje);
    }
}
