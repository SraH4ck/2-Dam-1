package com.diceworld.diceworld.utilidades.exception;

/**
 * No se esperaba un número negativo.
 */
public class NumeroNegativoException extends RuntimeException{
    public NumeroNegativoException(String mensaje){
        super(mensaje);
    }
}
