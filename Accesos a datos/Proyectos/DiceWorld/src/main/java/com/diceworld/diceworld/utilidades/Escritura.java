package com.diceworld.diceworld.utilidades;

import java.io.*;
import java.util.ArrayList;

/**
 * @author Antonio Mesa
 */
public class Escritura {

    //MODIFICAR PARAMETROS DE ENTRADA SEGÚN LA CANTIDAD DE VARIABLES QUE VAMOS A GUARDAR EN EL ARCHIVO
    /**
     * Escribe datos binarios en un archivo. Importante el orden que se escriben para luego la lectura debe ser el mismo
     * orden.
     *
     * @param fArchivo El archivo en el que se escribirán los datos binarios.
     * @param dato1 El primer dato entero a escribir.
     * @param dato2 El segundo dato flotante a escribir.
     * @param dato3 El tercer dato doble a escribir.
     * @throws IOException Si ocurre un error de entrada/salida durante la escritura del archivo.
     * @throws FileNotFoundException Si no se encuentra el archivo especificado.
     * @throws SecurityException Si se produce una violación de seguridad al intentar acceder al archivo.
     */
    public void escribeDatosBinarios(File fArchivo, int dato1, float dato2, double dato3) throws IOException,FileNotFoundException,SecurityException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fArchivo))) {// Al usar la estructura try-with-resources
                                                                                            // se cierran los recursos automáticamente al acabar el try
            dos.writeInt(dato1);
            dos.writeFloat(dato2);
            dos.writeDouble(dato3);
        }

    }

    /**
     * Escribe un objeto serializado en un archivo.
     *
     * @param objeto El objeto que se escribirá en el archivo.
     * @param archivo El archivo en el que se escribirá el objeto serializado.
     * @throws IOException Si ocurre un error de entrada/salida durante la escritura del archivo.
     * @throws FileNotFoundException Si no se encuentra el archivo especificado.
     * @throws SecurityException Si se produce una violación de seguridad al intentar acceder al archivo.
     */
    public void escribirArchivoSerializado(Object objeto, File archivo) throws IOException ,FileNotFoundException,SecurityException{
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(archivo));
            oos.writeObject(objeto);
        } finally {
            if (oos != null)
                oos.close();
        }
    }
    /**
     * Escribe un objeto serializado en un archivo utilizando el nombre del archivo.
     *
     * @param objeto El objeto que se escribirá en el archivo.
     * @param nombreArchivo El nombre del archivo en el que se escribirá el objeto serializado.
     * @throws FileNotFoundException Si no se encuentra el archivo.
     * @throws IOException Si ocurre un error de entrada/salida durante la escritura del archivo.
     * @throws FileNotFoundException Si no se encuentra el archivo especificado.
     */
    public void escribirArchivoSerializado(Object objeto, String nombreArchivo) throws FileNotFoundException, IOException {
        File fArchivo = new File(nombreArchivo);
        escribirArchivoSerializado(objeto, fArchivo);
    }

    /**
     * Escribe líneas de texto en un archivo.
     *
     * @param file El archivo en el que se escribirán las líneas de texto.
     * @param cadenasAEscribir La lista de cadenas que se escribirán en el archivo.
     * @throws IOException Si ocurre un error de entrada/salida durante la escritura del archivo.
     */
    public void escribirArchivoSobreEscribir(File file, ArrayList<String> cadenasAEscribir) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(file,false))) {
            for (String cadena : cadenasAEscribir) {
                pw.println(cadena);
            }
        }
    }
    public void escribirArchivoSinSobreEscribir(File file, ArrayList<String> cadenasAEscribir) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(file,true))) {
            for (String cadena : cadenasAEscribir) {
                pw.println(cadena);
            }
        }
    }

    /**
     * Escribe líneas de texto en un archivo utilizando un buffer.
     *
     * @param archivo El archivo en el que se escribirán las líneas de texto.
     * @param lineas La lista de cadenas que se escribirán en el archivo.
     * @throws IOException Si ocurre un error de entrada/salida durante la escritura del archivo.
     */
    public void escribirArchivoTextoBuffer(File archivo, ArrayList<String> lineas) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo)))//esta sintaxis del try cierra los recursos de forma automatica sin tener que especificarlo
        {
            for (String linea : lineas) {
                bw.write(linea);
                bw.newLine();
            }
        }
    }

}
