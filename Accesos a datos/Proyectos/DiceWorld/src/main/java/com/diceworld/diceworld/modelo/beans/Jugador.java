package com.diceworld.diceworld.modelo.beans;

import java.util.ArrayList;

/**
 * @author Antonio Mesa Sánchez
 */

public class Jugador  implements java.io.Serializable {
    private String nombre;
    private int partidasGanadas;
    private int puntosTotales;
    private int puntosPorPartida;
    private ArrayList<Dado> dados;


    public Jugador(String nombre, int partidasGanadas, int puntos) {
        this.nombre = nombre;
        this.partidasGanadas = partidasGanadas;
        this.puntosTotales = puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPartidasGanadas() {
        return partidasGanadas;
    }

    public int getPuntosTotales() {
        return puntosTotales;
    }

    public int getPuntosPorPartida() {
        return puntosPorPartida;
    }

    /**
     * Este método se encarga de simular la tirada de los dados y asiggnar los puntos para el jugador.
     * @param dados
     */

    public void tirarDados(ArrayList<Dado> dados) {
        for (Dado dado : dados) {
            puntosPorPartida = dado.resultado();
            puntosTotales += puntosPorPartida;
        }
    }


    public void setPartidasGanadas(int partidasGanadas) {
        this.partidasGanadas = partidasGanadas;
    }


    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", partidasGanadas=" + partidasGanadas +
                ", puntosTotales=" + puntosTotales +
                ", puntosPorPartida=" + puntosPorPartida +
                '}';
    }
}
