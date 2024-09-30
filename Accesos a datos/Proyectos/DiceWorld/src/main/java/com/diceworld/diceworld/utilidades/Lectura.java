package com.diceworld.diceworld.utilidades;

import java.io.*;
import java.util.ArrayList;

/**
 * @author Antonio Mesa
 */
public class Lectura {
    // TENEMOS QUE REALIZAR LA LECTURA EN EL MISMO ORDEN EN QUE SE HIZO LA ESCRITURA

    /**
     * Este método lee datos binarios desde un archivo, tenemos que tener en cuenta el orden en el que fueron escritos los datos
     * para luego leerlos en el mismo orden para que la lectura sea correcta.
     *
     * @param fArchivo Hace referencia al archivo donde leera los datos.
     * @param dato1 Dato que se leera. Es el primero que debemos leer.
     * @param dato2 Dato que se leera. Es el segundo que debemos leer.
     * @param dato3 Dato que se leera. Es el tercero que debemos leer.
     * @throws FileNotFoundException Si no se encuentra el archivo especificado.
     * @throws IOException  Si ocurre un error de entrada/salida durante la escritura del archivo.
     * @throws SecurityException Si se produce una violación de seguridad al intentar acceder al archivo.
     */
    public void leeDatosBinariosMuestraPantalla(File fArchivo,int dato1,float dato2,double dato3) throws FileNotFoundException, IOException,SecurityException {
        DataInputStream dis = new DataInputStream(new FileInputStream(fArchivo));
        System.out.println("Datos leídos:");
        System.out.println((dis.readInt()+", "+dis.readFloat()+", "+dis.readDouble()));
        dis.close();
    }
    /**
     * Lee datos binarios desde un archivo y los vuelca en otro archivo. Tenemos que tener en cuenta el orden en el que fueron escritos los datos
     * para luego leerlos en el mismo orden para que la lectura sea correcta.
     *
     * @param fArchivo El archivo desde el que se leerán los datos binarios.
     * @param fArchivoSalida El archivo en el que se volcarán los datos binarios leídos.
     * @throws FileNotFoundException Si no se encuentra el archivo de entrada o salida.
     * @throws IOException Sí ocurre un error de entrada/salida durante la lectura o escritura de archivos.
     * @throws SecurityException Si se produce una violación de seguridad al intentar acceder al archivo.
     */
    public void leeDatosBinariosVuelcaEnArchivo(File fArchivo, File fArchivoSalida) throws FileNotFoundException, IOException ,SecurityException{
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fArchivo));
             DataOutputStream dos = new DataOutputStream(new FileOutputStream(fArchivoSalida))) {
            int dato1 = dis.readInt();
            float dato2 = dis.readFloat();
            double dato3 = dis.readDouble();

            dos.writeInt(dato1);
            dos.writeFloat(dato2);
            dos.writeDouble(dato3);
        }
    }

    /**
     * Lee un objeto serializado desde un archivo.
     *
     * @param rutaArchivo La ruta del archivo desde el que se leerá el objeto serializado.
     * @return El objeto leído desde el archivo.
     * @throws IOException Si ocurre un error de entrada/salida durante la lectura del archivo.
     * @throws ClassNotFoundException Si la clase del objeto no se encuentra durante la deserialización.
     * @throws FileNotFoundException Si no se encuentra el archivo especificado.
     * @throws SecurityException Si se produce una violación de seguridad al intentar acceder al archivo.
     */
    public  Object leerArchivoSerializado(File rutaArchivo) throws IOException, ClassNotFoundException,FileNotFoundException ,SecurityException{
        Object obj = null;
        ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(rutaArchivo));
        obj = objectIn.readObject();
        objectIn.close();
        return obj;
    }
    /**
     * Lee un objeto serializado desde un archivo utilizando el nombre del archivo.
     *
     * @param nombreArchivo El nombre del archivo desde el que se leerá el objeto serializado.
     * @throws IOException Si ocurre un error de entrada/salida durante la lectura del archivo.
     * @throws ClassNotFoundException Si la clase del objeto no se encuentra durante la deserialización.
     * @throws FileNotFoundException Si no se encuentra el archivo especificado.
     * @throws SecurityException Si se produce una violación de seguridad al intentar acceder al archivo.
     */
    public void leerArchivoSerializado(String nombreArchivo) throws IOException, ClassNotFoundException,FileNotFoundException,SecurityException {
        File file = new File(nombreArchivo);
        leerArchivoSerializado(file);
    }

    /**
     * Lee líneas de texto desde un archivo y las devuelve como una lista de cadenas.
     *
     * @param file El archivo desde el que se leerán las líneas de texto.
     * @return Una lista de cadenas que contiene las líneas de texto leídas del archivo.
     * @throws IOException Si ocurre un error de entrada/salida durante la lectura del archivo.
     * @throws FileNotFoundException Si no se encuentra el archivo especificado.
     */
    public ArrayList<String> leeArchivo(File file) throws IOException,FileNotFoundException {
        ArrayList<String>cadenasLeidas = new ArrayList<>();
        String cadena;
        BufferedReader br = new BufferedReader(new FileReader(file));
        while((cadena = br.readLine())!=null){
            cadenasLeidas.add(cadena);
        }
        br.close();
        return cadenasLeidas;
    }
}
