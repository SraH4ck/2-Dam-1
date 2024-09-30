package com.diceworld.diceworld.utilidades.exception;

/**
 * Los valores que establecen los límites de un rango son iguales
 */
public class LimitesIgualesException extends Exception{
    public LimitesIgualesException (String mensaje){
        super (mensaje);
    }
}
