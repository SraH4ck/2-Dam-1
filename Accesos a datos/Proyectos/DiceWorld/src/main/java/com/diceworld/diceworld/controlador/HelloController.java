package com.diceworld.diceworld.controlador;
import com.diceworld.diceworld.modelo.beans.Dado;
import com.diceworld.diceworld.modelo.beans.Jugador;
import com.diceworld.diceworld.modelo.process.Procesos;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/***
 * @author Antonio Mesa Sánchez
 */

public class HelloController {

    @FXML
    private Button btnCargarDatos;

    @FXML
    private Button btnGuardaDatos;

    @FXML
    private Button btnJugar;

    @FXML
    private Button btnSalir;

    @FXML
    private Label lblArchivo;

    @FXML
    private Label lblAreaError;

    @FXML
    private Label lblNumCaras;

    @FXML
    private Label lblNumDados;

    @FXML
    private Label lblNumPartidas;

    @FXML
    private Label lblRankPartidas;

    @FXML
    private Label lblRankPuntosTotales;

    @FXML
    private Pane panel;

    @FXML
    private TextArea txAreaRankPartidas;

    @FXML
    private TextArea txAreaRankPuntosTotales;

    @FXML
    private TextField txfieldArchivo;

    @FXML
    private TextField txfieldAreaError;

    @FXML
    private TextField txfieldNumCaras;

    @FXML
    private TextField txfieldNumDados;

    @FXML
    private TextField txfieldNumPartidas;

    @FXML
    private TextFlow areaError;

    private Procesos procesos = new Procesos();

    private ArrayList<Dado> dados;
    private ArrayList<Jugador> jugadores;

    /***
     * Método que se encarga de cargar los datos mediante un bóton llamado cargar datos, los datos los carga
     * un archivo de texto (txt) o de un archivo serializado (dat).
     * @param event Representa el evento del bóton.
     */
    @FXML
    void cargarDatos(ActionEvent event) {

        File file = new File(txfieldArchivo.getText());
        try{
            if(inputUsuarioVacio()){
                mostrarError("Introduce un nombre de archivo");
            }else{
                obtenerDatos(file);
            }
        }catch (IOException | ClassNotFoundException e){
            mostrarError(e);
        }
    }

    /**
     * Este método obtiene los datos, según el archivo que haya introducido el usuario, es decir, según
     * la extensión que tenga el archivo, pues este método recopila los datos de la forma que requiera la
     * situación.
     * @param file El parámetro file representa el archivo introducido por el usuario.
     * @throws IOException
     * @throws ClassNotFoundException
     */

    private void obtenerDatos(File file) throws IOException, ClassNotFoundException {
        int posicionExtension;
        String extension;
        if (validarArchivo(file)) {
            posicionExtension = file.getName().indexOf("."); //devuelve la posición del punto

            // sumamos uno para quedarnos con el contenido despues del punto
            extension = file.getName().substring(posicionExtension + 1 );
            if(extension.equals("txt")){
                cargarArchivoTxt(file);
            } else if (extension.equals("dat")) {
                cargarArchivoDat(file);
            }
        }else {
            mostrarError("Error en el archivo");
        }
    }

    /**
     *El método cargarArchivosDat primero limpia los componentes donde mostrara la información para asegurarse
     * de que no se muestre la información duplicada, luego crea dos contenedores para guardar los resultados ordenado por
     * puntos y por partidas ganadas y por último muestra el contenido.
     * @param file representa el archivo que debe cargar.
     * @throws IOException Esta excepción puede producirse si tenemos problemas con el archivo, por ejemplo:
     * el archivo no existe, o no tenemos permisos de lectura o escritura, etc.
     * @throws ClassNotFoundException Esta excepción se puede dar al recuperar los objetos del archivo serializado
     * ya que en tiempo de ejecución no encuentre la clase.
     */

    private void cargarArchivoDat(File file) throws IOException, ClassNotFoundException {
        jugadores = procesos.cargarDatosDat(file);

        borrarAreaRankingPartidas();
        borrarAreaRankingPuntos();

        ArrayList<Jugador> jugadoresOrdenadosPorPuntos = ordenarJugadoresPorPuntos();
        ArrayList<Jugador>jugadoresOrdenadosPorPartidasGanadas = ordenarJugadoresPorPartidasGanadas();

        mostrarDatosPartidasDat(jugadoresOrdenadosPorPartidasGanadas);
        mostrarDatosPuntosDat(jugadoresOrdenadosPorPuntos);

    }

    private void borrarAreaRankingPuntos() {
        txAreaRankPuntosTotales.clear();
    }

    private void borrarAreaRankingPartidas() {
        txAreaRankPartidas.clear();
    }

    private ArrayList<Jugador> ordenarJugadoresPorPuntos() {
        jugadores.sort((Jugador j1, Jugador j2) -> Integer.compare(j2.getPuntosTotales(), j1.getPuntosTotales()));
        return jugadores;
    }

    private ArrayList<Jugador> ordenarJugadoresPorPartidasGanadas() {
        jugadores.sort((Jugador j1, Jugador j2) -> Integer.compare(j2.getPartidasGanadas(), j1.getPartidasGanadas()));
        return jugadores;
    }

    /**
     * Este método primero limpia la zona donde mostrará la información para evitar duplicado de información
     * luego carga todas las lineas del archivo en un ArrayList y luego muestra los resultados en sus respectivos
     * componentes. Tambíen borra la zona de errores para mejorar la experiencia del usuario en caso de haber errores
     * antiguos impresos.
     * @param file Representa el archivo que introduce el usuario
     * @throws IOException Esta excepción puede producirse si tenemos problemas con el archivo, por ejemplo:
     * el archivo no existe, o no tenemos permisos de lectura o escritura, etc.
     */

    private void cargarArchivoTxt(File file) throws IOException {
        ArrayList<String> datosJugadores;
        limpiarAreaError();
        datosJugadores = procesos.cargarDatos(file);
        crearJugadores(datosJugadores);
        mostrarDatosPartidas();
        mostrarDatosPuntos();
    }

    private boolean inputUsuarioVacio() {
        return txfieldArchivo.getText().isEmpty();
    }

    /**
     * Este método nos asegura que el archivo es válido para poder operar con el, comprueba los siguientes aspectos:
     * Primero que exista, luego si es un archivo y no otro tipo , también valida si se puede leer
     * y por último si se puede escribir en el para poder volcar los resultados de las partidas.
     * @param file representa el archivo que introduce el usuario.
     * @return true o false si el archivo cumple con los requisitos.
     * @throws IOException Esta excepción puede producirse si tenemos problemas con el archivo, por ejemplo:
     * el archivo no existe, o no tenemos permisos de lectura o escritura, etc.
     */
    private boolean validarArchivo(File file) throws IOException {
        return file.exists() && file.isFile() && file.canRead() && file.canWrite();
    }

    private void mostrarDatosPartidasDat(ArrayList<Jugador> jugadores){
        int puesto = 1;
        ordenarJugadoresPorPartidasGanadas();
        for(Jugador jugador:jugadores){
            txAreaRankPartidas.appendText(puesto + "º " + jugador.getNombre() + "--> " + jugador.getPartidasGanadas() + "\n");
            puesto++;
        }
    }

    /**
     * El método mostrarDatosPartidas muestra en el componente de visualización correspondiente
     * la información de los jugadores ordenada por partidas ganadas.
     */

    private void mostrarDatosPartidas() {
        int puesto = 1;
        borrarAreaRankingPartidas();
        ordenarJugadoresPorPartidasGanadas();

        for (Jugador jugador : jugadores) {
            mostrarInformacionRankingPartidas(jugador,puesto);
            puesto++;
        }
    }

    private void crearJugadores(ArrayList<String> datosParaCrearJugadores) {
        jugadores = procesos.CrearJugadores(datosParaCrearJugadores);
    }

    private void mostrarInformacionRankingPartidas(Jugador jugador,int puesto) {
        txAreaRankPartidas.appendText(puesto + "º " + jugador.getNombre() + "--> " + jugador.getPartidasGanadas() + "\n");
    }

    private void mostrarDatosPuntosDat(ArrayList<Jugador> jugadores){
        int puesto = 1;
        ordenarJugadoresPorPuntos();
        for (Jugador jugador: jugadores){
            txAreaRankPuntosTotales.appendText(puesto + "º " +jugador.getNombre() + "--> " + jugador.getPuntosTotales() + "\n");
            puesto++;
        }
    }

    /**
     * Este método muestra los datos ordenado por los puntos en el componente de visualización de los puntos
     */

    private void mostrarDatosPuntos() {
        int puesto = 1;
        borrarAreaRankingPuntos();
        ordenarJugadoresPorPuntos();

        for(Jugador jugador: jugadores){
            mostrarInformacionRankingPuntos(jugador,puesto);
            puesto++;
        }
    }

    private void mostrarInformacionRankingPuntos(Jugador jugador,int puesto) {
        txAreaRankPuntosTotales.appendText(puesto + "º " +jugador.getNombre() + "--> " + jugador.getPuntosTotales()+ "\n");
    }

    /**
     * El método limpiarAreaError comprueba si hay algún error en el componente antes de mostrar el error correspondiente,
     * si lo hay lo borra y luego muestra el nuevo error.
     */

    private void limpiarAreaError(){
        if(areaError.getChildren() != null) areaError.getChildren().clear();
    }

    /**
     * Este método muestra el error que se pueda generar en los componenetes que se recoge información sobre los dados.
     * @param cantidadDados Representa la cantidad de dados introducida por el usuario
     * @param numCarasDados Representa la cantidad de caras del dado que ha introducido el usuario
     * @param numPartidas Representa el número de partidas que ha introducido el usuairo
     */

    private void determinarErrorComponentesDado(int cantidadDados, int numCarasDados, int numPartidas) {
        limpiarAreaError();
        if (cantidadDados < 1){
            mostrarError("Debes elegir mínimo un dado\n");
        }
        if (numCarasDados < 3){
            mostrarError("Debes elegir un dado mínimo de 3 caras\n");
        }
        if (numPartidas < 1){
            mostrarError("Debes elegir mínimo una partida para poder jugar\n");
        }
    }

    /**
     * Este método se encarga de mostrar el error correspondiente en el area de errores.
     * @param error Representa el error que debe mostrar.
     */

    private void mostrarError(String error){
        limpiarAreaError();
        Text text = new Text(error);
        areaError.getChildren().add(text);
    }

    /**
     * Este método muestra en el área de error la excepción que se acontece.
     * @param e Representa la excepción que se produjo.
     */

    private void mostrarError(Exception e) {
        limpiarAreaError();
        Text texto = new Text(e.getMessage());
        areaError.getChildren().add(texto);
    }

    /**
     * El método guardarDatos, se encarga de guardar la información en dos formatos, en texto plano (.txt)
     * y serializado (.dat)
     * @param event Representa el evento del botón
     * @throws IOException Esta excepción puede producirse si tenemos problemas con el archivo, por ejemplo:
     * el archivo no existe, o no tenemos permisos de lectura o escritura, etc.
     */

    @FXML
    void guardarDatos(ActionEvent event) throws IOException {
        boolean guardadoConExito;
        boolean guardadoConExitoDat;
        String archivoConExtension = txfieldArchivo.getText();
        String[] nombreArchivo = archivoConExtension.split("\\.");
        if(nombreArchivo.length > 0){
            String nombreArchivoDat = nombreArchivo[0] + ".dat" ;
            String nombreArchivoTxt = nombreArchivo[0] + ".txt" ;
            if(jugadores != null){
                guardadoConExitoDat = procesos.guardarDatosDat(new File(nombreArchivoDat),jugadores);
                guardadoConExito = procesos.guardarDatosTxt(new File(nombreArchivoTxt),jugadores);
                if (!guardadoConExito && !guardadoConExitoDat){
                    mostrarError("Problemas al guardar el archivo. Compruebe haber cargado antes el archivo");
                }
            }
        }
    }

    /**
     *En el método jugar se llevan a cabo las operatorias para simular las partidas.
     * @param event Representa el evento del botón
     */

    @FXML
    void jugar(ActionEvent event) {
        try{
            limpiarAreaError();
            dados = new ArrayList<>();

            int cantidadDados = Integer.parseInt(txfieldNumDados.getText());
            int numCarasDados = Integer.parseInt(txfieldNumCaras.getText());
            int numPartidas = Integer.parseInt(txfieldNumPartidas.getText());

            if(cantidadDados > 0 && numCarasDados >= 3 && numPartidas > 0){
                crearDados(cantidadDados,numCarasDados);
                jugarPartida(numPartidas);
            }else {
                determinarErrorComponentesDado(cantidadDados,numCarasDados,numPartidas);
            }
        }catch (NumberFormatException e){
            mostrarError("Asegurate de introducir números en los campos requerido para poder jugar");
        }
    }

    /**
     * Este método se encarga de jugar tantas partidas como el usuario indique
     * @param numPartidas Representa la cantidad de partidas que el usuario quiere jugar
     */

    private void jugarPartida(int numPartidas) {
        if (jugadores != null) {

            // Bucle para jugar varias partidas
            partidas(numPartidas);
        } else {
            mostrarError("Debes cargar un archivo antes de jugar");
        }
    }

    /**
     * Este método representa la partida como tal
     * @param numPartidas Representa la cantidad de partidas que se jugarán
     */

    private void partidas(int numPartidas) {
        for (int partida = 1; partida <= numPartidas; partida++) {

            Jugador jugadorConMasPuntos = null;
            int maxPuntos = Integer.MIN_VALUE;

            // Los jugadores tiran los dados en la partida
            tiradasJugadores();

            // Determinar quién tiene la mayor puntuación
            jugadorConMasPuntos = determinarMayorPuntuacion(maxPuntos,jugadorConMasPuntos);

            // Incrementar las partidas ganadas del jugador con más puntos
            incrementarPartidasGanadas(jugadorConMasPuntos);
        }
    }

    private void incrementarPartidasGanadas(Jugador jugadorConMasPuntos) {
        if (jugadorConMasPuntos != null) {
            sumarPartidaGanada(jugadorConMasPuntos);
        }
    }

    private void sumarPartidaGanada(Jugador jugadorConMasPuntos) {
        jugadorConMasPuntos.setPartidasGanadas(jugadorConMasPuntos.getPartidasGanadas() + 1);
    }

    /**
     * Este método compara todo los puntos sacados por los jugadores en una partida para determinar quien tiene mayor
     * puntuación.
     * @param maxPuntos Representa la cantidad maxima de puntos.
     * @param jugadorConMasPuntos Devuelve el jugador con más puntos
     * @return
     */

    private Jugador determinarMayorPuntuacion(int maxPuntos, Jugador jugadorConMasPuntos) {
        for (Jugador jugador : jugadores) {
            int puntosJugador = jugador.getPuntosPorPartida();

            if (puntosJugador > maxPuntos) {
                maxPuntos = puntosJugador;
                jugadorConMasPuntos = jugador;
            }
        }
        return jugadorConMasPuntos;
    }

    /**
     * Este método se encarga de las tiradas de los jugadores.
     */

    private void tiradasJugadores() {
        for (Jugador jugador : jugadores) {
            jugador.tirarDados(dados);
        }
    }

    /**
     * Este método crea la cantidad de dados que desea el usuario con el número de caras deseado.
     * @param cantidadDados Cantidad de dados que hay que crear.
     * @param numCarasDados El número de caras que tendrá el dado.
     */
    private void crearDados(int cantidadDados, int numCarasDados) {
        for(int i = 0; i < cantidadDados; i++){
            dados.add(new Dado(numCarasDados));
        }
    }

    /**
     * Este método se encarga de mostrar una alerta cuando el usuario pulsa el botón salir para pedir una confirmación
     * si quiere salir del programa.
     * @param event
     */

    @FXML
    void salir(ActionEvent event) {

        // Crear un diálogo de confirmación
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmación");
        alert.setHeaderText("¿Estás seguro de que quieres salir?");
        alert.setContentText("Si sales, se cerrará la aplicación.");

        if (alert.showAndWait().get() == ButtonType.OK) {
            Platform.exit();  // Cerrar la aplicación si el usuario presiona Aceptar
        }
    }
}