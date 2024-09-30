package com.diceworld.diceworld.modelo.beans;

import java.util.Random;

/**
 * @author Antonio Mesa Sánchez
 */
public class Dado {
    private int numCaras;
    private int resultado;

    public Dado(int numCaras) {
        this.numCaras = numCaras;
    }

    public int getNumCaras() {
        return numCaras;
    }

    /**
     * Simula el resultado de la tirada.
     * @return Devuelve el resultado de la tirada.
     */

    public int resultado(){
        Random random = new Random();
        resultado = random.nextInt(numCaras) + 1; // Genera un número aleatorio entre 1 y numCaras
        return resultado;
    }
}
