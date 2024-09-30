package com.diceworld.diceworld.modelo.process;
import com.diceworld.diceworld.modelo.beans.Jugador;
import com.diceworld.diceworld.utilidades.Escritura;
import com.diceworld.diceworld.utilidades.Lectura;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Antonio Mesa Sánchez
 */

public class Procesos {
    private Lectura lectura;
    private ArrayList<Jugador> jugadoresCreados;
    private Escritura escritura;

    public Procesos() {
        lectura = new Lectura();
        escritura = new Escritura();
        jugadoresCreados = new ArrayList<>();
    }

    public ArrayList<String> cargarDatos(File file) throws IOException {
        return lectura.leeArchivo(file);
    }

    /**
     * Este método extrae datos de un archivo txt para crear un o más objetos Jugador y los añade a un
     * contenedor de jugadores.
     * @param datosExtraer Son los datos que hay en el archivo txt.
     * @return
     */

    public ArrayList<Jugador> CrearJugadores(ArrayList<String> datosExtraer) {
        if (jugadoresCreados.isEmpty()) {
            for(String dato: datosExtraer){
                String[] partes = dato.split(":");
                String nombre = partes[0];
                int partidasGanas = Integer.parseInt(partes[1]);
                int puntos = Integer.parseInt(partes[2]);
                Jugador jugador = new Jugador(nombre, partidasGanas, puntos);
                jugadoresCreados.add(jugador);
            }
        }
        return jugadoresCreados;
    }

    /**
     * Este método guarda los objeto que hay en el contenedor que recibe para serializarlo.
     * @param file Representa el archivo donde se guardará el contenido
     * @param jugadores Representa un contenedor donde están los objeto que guardará de forma serializada
     * @return Retorna true si el proceso de guardar se realiza de forma correcta, si no se acontence una excepción
     * que será gestionada por el método que llama a guardarDatosDat.
     * @throws IOException Esta excepción se acontece si se produce algún error con el archivo, por ejemplo que no
     * podamos leerlo, escribir en él o que no exista
     */

    public boolean guardarDatosDat(File file, ArrayList<Jugador>jugadores) throws IOException {
        if(jugadores.isEmpty()){
            return false;
        }else{
            escritura.escribirArchivoSerializado(jugadores,file);
        }
        return true;
    }

    /**
     * Este método se encarga de devolver un ArrayList de tipo jugador que se encuentra serializado
     * @param file Representa el archivo donde deberá leer.
     * @return Devuelve un ArrayList de tipo Jugador
     * @throws IOException Esta excepción se acontece si se produce algún error con el archivo, por ejemplo que no
     * podamos leerlo, escribir en él o que no exista
     * @throws ClassNotFoundException Esta excepción se acontece cuando en tiempo de ejecución no es capaz de determina de
     * la clase que se trata.
     */

    public ArrayList<Jugador> cargarDatosDat(File file) throws IOException, ClassNotFoundException {
        return (ArrayList<Jugador>) lectura.leerArchivoSerializado(file);
    }

    /**
     * Este método se encarga de guardar los datos de los jugadores en texto plano
     * @param file Representa el archivo donde debe guardarlo
     * @param datosJugadores Representa un contenedor donde están todos los jugadores.
     * @return Devuelve un true si el proceso es correcto, si no se lanzará una excepción donde el método que llama a este
     * lo gestionará
     * @throws IOException Esta excepción se acontece si se produce algún error con el archivo, por ejemplo que no
     * podamos leerlo, escribir en él o que no exista
     */

    public boolean guardarDatosTxt(File file,ArrayList<Jugador> datosJugadores) throws IOException {
        ArrayList<String> jugadoresTxt = new ArrayList<>();
        if(datosJugadores.isEmpty()){
            return false;
        }else{
            for (Jugador jugador:datosJugadores){
                jugadoresTxt.add(jugador.getNombre() + ":" +jugador.getPartidasGanadas() + ":" + jugador.getPuntosTotales());
            }
            escritura.escribirArchivoSobreEscribir(file, jugadoresTxt);
        }
        return true;
    }
}
