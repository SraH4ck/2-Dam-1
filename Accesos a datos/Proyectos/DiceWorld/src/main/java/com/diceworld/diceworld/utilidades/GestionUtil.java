package com.diceworld.diceworld.utilidades;

import com.diceworld.diceworld.utilidades.exception.CadenaVaciaException;
import com.diceworld.diceworld.utilidades.exception.IntentosAcabadosException;
import com.diceworld.diceworld.utilidades.exception.NumeroNegativoException;

public class GestionUtil {
    private Util util = new Util();

    /**
     * El método pideEntero() usa la clase Util para pedir un número entero y si producen errores, los gestiona, asignando
     * un número de intentos y se lo comunica al usuario. Si el número de intentos llega a 0 se lanza una excepción (IntentosAcabadosException),
     * si esto ocurre no se devolverá ningún número
     * @param mensaje Es el mensaje que muestra antes de la toma de datos.
     * @return Devuelve el número introducido por el usuario
     * @throws IntentosAcabadosException Se lanza esta excepción cuando el usuario ha fallado 3 veces en la introdución de datos.
     * @throws NumeroNegativoException Se lanza esta excepción cuando el número es negativo y se restará un intento.
     * @throws NumberFormatException Se lanza está excepción cuando se introduce un caracter no númerico y es imposible convertir ese carcter a número.
     */
    public int pideEntero(String mensaje) throws IntentosAcabadosException {
        int numeroIntentos = 3;
        int numero = -1;
        do {
            try{
                numero = util.pideEntero(mensaje);
                if (numero < 0) {throw new NumeroNegativoException("Has introducido un número negativo");}
            }catch (NumberFormatException e) {
                System.out.println("No has introducido un número");
                numeroIntentos--;
                System.out.println("Numeros de intentos: " + numeroIntentos);
            }catch (NumeroNegativoException e){
                System.out.println(e.getMessage());
                numeroIntentos--;
                System.out.println("Numeros de intentos: " + numeroIntentos);
            }
        }while(numeroIntentos > 0 && numero < 0);
        if (numeroIntentos==0) {throw new IntentosAcabadosException();}
        return numero;
    }

    /**
     * El método pideEntero() usa la clase Util para pedir un número entero y si producen errores, los gestiona, asignando
     * un número de intentos y se lo comunica al usuario. Si el número de intentos llega a 0 se lanza una excepción (IntentosAcabadosException),
     * si esto ocurre no se devolverá ningún número
     * @return Devuelve el número introducido por el usuario
     * @throws IntentosAcabadosException Se lanza esta excepción cuando el usuario ha fallado 3 veces en la introdución de datos.
     * @throws NumeroNegativoException Se lanza esta excepción cuando el número es negativo y se restará un intento.
     * @throws NumberFormatException Se lanza está excepción cuando se introduce un caracter no númerico y es imposible convertir ese carcter a número.
     */

    public int pideEntero() throws IntentosAcabadosException{
        int numeroIntentos = 3;
        int numero = -1;
        do {
            try{
                numero = util.pideEntero();
                if (numero < 0) {throw new NumeroNegativoException("Has introducido un número negativo");}
            }catch (NumberFormatException e) {
                System.out.println("No has introducido un número");
                numeroIntentos--;
                System.out.println("Numeros de intentos: " + numeroIntentos);
            }catch (NumeroNegativoException e){
                System.out.println(e.getMessage());
                numeroIntentos--;
                System.out.println("Numeros de intentos: " + numeroIntentos);
            }
        }while(numeroIntentos > 0 && numero < 0);
        if (numeroIntentos==0) {throw new IntentosAcabadosException();}
        return numero;
    }

    /**
     * Lee una cadena desde teclado. La convierte a un double y si no es posible se lanza una NumberFormatException. El número
     * decimal se indica con un punto.
     * @param mensaje El mensaje que se muestra antes de pedir el dato
     * @return El número leído
     * @throws IntentosAcabadosException
     * @throws NumeroNegativoException
     */
    public double pideDouble(String mensaje) throws IntentosAcabadosException{ //Informar que que el número negativo se indica con un punto
    double numeroDouble = -1;
    int numeroIntentos = 3;
    do {
        try {
            numeroDouble = util.pideDouble(mensaje);
            if (numeroDouble < 0) {throw new NumeroNegativoException("Has introducido un número negativo");}
        }catch (NumberFormatException e){
            numeroIntentos--;
            System.out.println("No has introducido un número\nNúmeros de intentos: "+ numeroIntentos);
        }catch (NumeroNegativoException e){
            numeroIntentos--;
            System.out.println("Has introducido un número negativo\nNumeros de intentos: " + numeroIntentos);
        }
    }while(numeroIntentos > 0 && numeroDouble < 0);
    if (numeroIntentos==0) {throw new IntentosAcabadosException();}
    return numeroDouble;
}

    /**
     * Lee una cadena desde teclado. La convierte a un double y si no es posible se lanza una NumberFormatException. El número
     * decimal se indica con un punto.
     * @return El número leído
     * @throws IntentosAcabadosException
     * @throws NumeroNegativoException
     */
    public double pideDouble() throws IntentosAcabadosException{ //Informar que que el número negativo se indica con un punto
        double numeroDouble = -1;
        int numeroIntentos = 3;
        do {
            try {
                numeroDouble = util.pideDouble();
                if (numeroDouble < 0) {throw new NumeroNegativoException("Has introducido un número negativo");}
            }catch (NumberFormatException e){
                numeroIntentos--;
                System.out.println("No has introducido un número\nNúmeros de intentos: "+ numeroIntentos);
            }catch (NumeroNegativoException e){
                numeroIntentos--;
                System.out.println("Has introducido un número negativo\nNumeros de intentos: " + numeroIntentos);
            }
        }while(numeroIntentos > 0 && numeroDouble < 0);
        if (numeroIntentos==0) {throw new IntentosAcabadosException();}
        return numeroDouble;
    }

    /**
     * Lee una cadena desde teclado. No se acepta cadena vacía.
     * @param mensaje El mensaje que se muestra antes de solicitar el dato.
     * @return La cadena leída.
     * @throws IntentosAcabadosException
     */
    public String pideCadena(String mensaje) throws IntentosAcabadosException{
        int numeroIntentos = 3;
        String cadena="";
        do {
            try{
                cadena = util.pideCadena(mensaje);
            }catch (CadenaVaciaException e){
                System.out.println("Error, vuelve a intentarlo");
                numeroIntentos --;
                System.out.println("Numero de intentos restantes: " + numeroIntentos);
            }
        }while(numeroIntentos > 0 && cadena.isEmpty());
        if (numeroIntentos==0) {throw new IntentosAcabadosException();}
        return cadena;
    }

    /**
     * Lee una cadena desde teclado. No se acepta cadena vacía.
     * @return La cadena leída.
     * @throws IntentosAcabadosException
     */
    public String pideCadena() throws IntentosAcabadosException{
        int numeroIntentos = 3;
        String cadena="";
        do {
            try{
                cadena = util.pideCadena();
            }catch (CadenaVaciaException e){
                System.out.println("Error, vuelve a intentarlo");
                numeroIntentos --;
                System.out.println("Numero de intentos restantes: " + numeroIntentos);
            }
        }while(numeroIntentos > 0 && cadena.isEmpty());
        if (numeroIntentos==0) {throw new IntentosAcabadosException();}
        return cadena;
    }

    /**
     * Este método se usará para cuando se necesite introducir un intro para salir o para algún proceso que se necesite
     * una cadena vacía.
     * @param mensaje Es el mensaje que se le mostraraá al usuario para que sepa como proceder.
     * @return Devuelve la cadena vacía.
     * @throws IntentosAcabadosException
     */
    public String pideIntro(String mensaje) throws IntentosAcabadosException{
        int numeroIntentos = 3;
        String cadena ="";
        do {
            cadena = util.pideIntro(mensaje);
            if(!cadena.isEmpty()){
                System.out.println("No has introducido un Intro");
                numeroIntentos--;
                System.out.println("Números de intentos restantes: " + numeroIntentos+"\n");
            }
        }while(numeroIntentos>0 && !cadena.isEmpty());
        if (numeroIntentos==0) {throw new IntentosAcabadosException();}
        return cadena;
    }

    public void limpiarBuffer() {
        util.limpiarBuffer();
    }
}
