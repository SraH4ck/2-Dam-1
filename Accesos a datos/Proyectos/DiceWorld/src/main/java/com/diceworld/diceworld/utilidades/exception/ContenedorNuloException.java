package com.diceworld.diceworld.utilidades.exception;

/**
 * No se esperaba recibir un contenedor nulo.
 */
public class ContenedorNuloException extends RuntimeException {
        public ContenedorNuloException(String mensaje){
            super(mensaje);
        }
    }
