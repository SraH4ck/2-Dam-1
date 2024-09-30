package com.diceworld.diceworld.utilidades;


import com.diceworld.diceworld.utilidades.exception.CadenaVaciaException;
import com.diceworld.diceworld.utilidades.exception.FueraDeRangoException;
import com.diceworld.diceworld.utilidades.exception.LimitesIgualesException;
import com.diceworld.diceworld.utilidades.exception.NumeroNegativoException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase de utilidad
 */
public class Util {

    /**
     * Objeto para toma de datos por teclado
     */
    private Scanner teclado;

    /**
     * Constructor por defecto
     */
    public Util() {
        this.teclado = new Scanner(System.in);
    }

    /**
     * Lee una cadena desde teclado mostrando previamente un mensaje. Si se introduce una cadena vacía, se lanza una
     * excepción CadenaVaciaException.
     * @param mensaje El mensaje que se muestra antes de solicitar el dato.
     * @return La cadena leída.
     * @throws  CadenaVaciaException En caso de introducir una cadena vacía
     */
    public String pideCadena(String mensaje) {
        System.out.print(mensaje);
        return this.pideCadena();
    }

    /**
     * Lee una cadena desde teclado. Si se introduce una cadena vacía, se lanza una excepción CadenaVaciaException.
     * @return La cadena leída.
     * @throws  CadenaVaciaException En caso de introducir una cadena vacía
     */

    public String pideCadena(){
        String cadena = "";
        cadena = teclado.nextLine();
        if (cadena.trim().isEmpty()) {
            throw new CadenaVaciaException("Ha introducido una cadena vacía");
        }
        return cadena;
    }

    /**
     * Este método se usará para cuando se necesite introducir un intro para salir o para algún proceso que se necesite
     * una cadena vacía.
     * @param mensaje Es el mensaje que se le mostraraá al usuario para que sepa como proceder.
     * @return Devuelve la cadena vacía.
     */
    public String pideIntro(String mensaje){
        String cadena;
        System.out.println(mensaje);
        cadena = teclado.nextLine();
        return cadena;
    }

    /**
     * Lee una cadena desde teclado mostrando previamente un mensaje. Se convierte a un entero y si no es posible
     * se lanza una NumberFormatException.
     * @param mensaje El mensaje que se muestra antes de solicitar el dato.
     * @return El número entero leído
     * @throws  NumberFormatException En caso de no poder convertir la cadena en un entero.
     */
    public int pideEntero(String mensaje) {
        System.out.print(mensaje);
        return this.pideEntero();
    }

    /**
     * Lee una cadena desde teclado. La convierte a un entero y si no es posible se lanza una NumberFormatException.
     * @return El número entero leído
     * @throws  NumberFormatException En caso de no poder convertir la cadena en un entero.
     */
    public int pideEntero(){
        int numero;
        String cadena;
        cadena = teclado.nextLine();
        numero=Integer.parseInt(cadena);
        return numero;
    }
    /**
     * Lee una cadena desde teclado. La convierte a un double y si no es posible se lanza una NumberFormatException.
     * @param mensaje El mensaje que se solicita antes de pedir el dato
     * @return El número leído
     * @throws  NumberFormatException En caso de no poder convertir la cadena en un double.
     */
    public double pideDouble(String mensaje){
        System.out.print(mensaje);
        return this.pideDouble();
    }

    /**
     * Lee una cadena desde teclado. La convierte a un double y si no es posible se lanza una NumberFormatException.
     * @return El número leído
     * @throws  NumberFormatException En caso de no poder convertir la cadena en un double.
     */

    public double pideDouble(){
        double numero;
        String cadena;
        cadena = teclado.nextLine();
        numero=Double.parseDouble(cadena);
        return numero;
    }

    /**
     *
     * @param mensaje El mensaje que se muestra antes de pedir los números para establecer los rangos
     * @param limite1 número que se utilizará de rango
     * @param limite2 número que se utilizará de rango
     * @return Devuelve un número introducido que se encuentra dentro del rango establecido por límte 1 y límite 2
     * @throws LimitesIgualesException Si los límites son el mismo número se lanzará esta excepción, ya que no podremos devolver ningún
     * número comprendido entre ese rango
     * @throws  NumberFormatException No se ha introducido un número cuando es requerido
     * @throws FueraDeRangoException Se introduce un número fuera del rango entre límte 1 y límite 2
     */
    public int pideEnteroConLimites (String mensaje, int limite1, int limite2) throws LimitesIgualesException {
        int numero = 0;
        int limiteMenor;
        int limiteMayor;
        String cadena;
        if (limite1>limite2){
            limiteMayor=limite1;
            limiteMenor= limite2;
        }else if (limite2>limite1){
            limiteMayor=limite2;
            limiteMenor= limite1;
        }else throw new LimitesIgualesException("Los limites son iguales");
        System.out.print(mensaje + " entre " + limiteMenor + " y  " + limiteMayor + ": ");
        cadena = teclado.nextLine();
        numero=Integer.parseInt(cadena);
        if (numero>limiteMayor|| numero<limiteMenor){
            throw new FueraDeRangoException("El numero introducido esta fuera de rango");
        }
        return numero;
    }

    /**
     * @param mensaje El mensaje que se muestra antes de pedir los números para establecer los rangos
     * @param limite1 número que se utilizará de rango
     * @param limite2 número que se utilizará de rango
     * @return Devuelve un número introducido que se encuentra dentro del rango establecido por límte 1 y límite 2
     * @throws LimitesIgualesException Si los límites son el mismo número se lanzará esta excepción, ya que no podremos devolver ningún
     * número comprendido entre ese rango
     * @throws  NumberFormatException No se ha introducido un número cuando es esperado.
     * @throws  FueraDeRangoException Se introduce un número fuera del rango entre límte 1 y límite 2
     */
    public double pideDoubleConLimites (String mensaje, double limite1, double limite2) throws LimitesIgualesException {
        double numero = 0;
        double limiteMenor;
        double limiteMayor;
        if (limite1>limite2){
            limiteMayor=limite1;
            limiteMenor= limite2;
        }else if (limite2>limite1){
            limiteMayor=limite2;
            limiteMenor= limite1;
        }else throw new LimitesIgualesException("Los limites son iguales");
        System.out.print(mensaje + " entre " + limiteMayor + " y  " + limiteMenor + ": ");
        String cadena = teclado.nextLine();
        numero=Double.parseDouble(cadena);
        if (numero>limiteMayor||numero<limiteMenor) throw new FueraDeRangoException("El numero introducido esta fuera de rango");
        return numero;
    }

    /**
     * Este método primero verifica que el DNI introducido, respete el formato de 8 dígitos y una letra, si es así luego llama
     * al método dniValido() para realizar el cálculo de la letra del DNI y comprobar que concuerden el número con la letra que tiene
     * el DNI.
     * @param dni Es el dni que tiene que verificar el método
     * @return false si no corresponde el formato o la respuesta del método dniValido()
     */

    public boolean validarDNI(String dni) {
        // Expresión regular para el formato del DNI español
        String patron = "^(\\d{8})([A-HJ-NP-TV-Z])$";
        // Crear el patrón y el objeto Matcher
        Pattern pattern = Pattern.compile(patron); // Excepción PatternSyntaxException
        Matcher matcher = pattern.matcher(dni);
        // El formato del DNI es incorrecto
        if (!matcher.matches()) return false;
        return dniValido(matcher);
    }

    /**
     * Este método recibe un DNI con un formato correcto previamente verificado, luego con ese DNI coge el número para calcular
     * la letra para ver si corresponde con la que tiene el DNI introducido y así verificar que es válido
     * @param matcher El dni con su formato verificado
     * @return false si la letra calculada no coincide con la del DNI proporcionado o true si coincide.
     */
    public boolean dniValido(Matcher matcher){
        String numeroDNI = matcher.group(1); //Excepcion IllegalStateException IndexOutOfBoundsException
        String letraControl = matcher.group(2); //Excepcion IllegalStateException IndexOutOfBoundsException
        // Calcular la letra de control esperada
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int numero = Integer.parseInt(numeroDNI); //Excepcion NumberFormatException
        int indice = numero % 23;
        char letraEsperada = letras.charAt(indice); //Excepcion IndexOutOfBoundsException
        // Verificar si la letra de control es correcta
        if (letraEsperada == letraControl.charAt(0)) return true; //Excepcion IndexOutOfBoundsException
        else return false;
    }

    /**
     * Este método calcula una letra según el número del dni proporcionado
     * @param numeroDNI DNI que se le proporciona para calcular la letra
     * @return Devuelve la letra calculada del DNI proporcionado
     */
    private char calcularLetraDNI(int numeroDNI) {
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int indiceLetra = numeroDNI % 23;
        return letras.charAt(indiceLetra); //Excepcion IndexOutOfBoundsException
    }

    public String pideFecha(){
        return pideCadena("Introduzca una fecha con el formato dd/MM/yyyy: ");
    }

    /**
     * Este método llama al método pideFecha() para pedir una fecha y luego esa fecha recibida la valida.
     * @return true si la fecha es correctamente validada.
     * @throws ParseException Se lanza la excepción ParseException si la fecha no es válida.
     */
    public boolean validarFormatoFecha() throws ParseException {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        formatoFecha.setLenient(false); // Evita la interpretación flexible de fechas y así no ajustará de forma automatica
        // (por ejemplo, convertir el 32 de enero al 1 de febrero).
        String fecha = pideFecha();
        // Intenta parsear la fecha. Si tiene éxito, el formato es válido.
        Date fechaParseada = formatoFecha.parse(fecha);
        return true;
    }

    /**
     * Este método pide un numero positivo
     * @param mensaje Es el mensaje que se muestra antes de pedir el dato
     * @return El entero leído
     * @throws NumeroNegativoException Si se introduce un número negativo
     * @throws NumberFormatException No se ha introducido un número cuando es esperado.
     */
    public int pideEnteroPositivo(String mensaje) {
        System.out.print(mensaje);
        return this.pideEnteroPositivo();
    }

    /**
     * Este método pide un numero positivo
     * @return El número leído
     * @throws NumeroNegativoException Si se introduce un número negativo
     * @throws NumberFormatException No se ha introducido un número cuando es esperado.
     */
    public int pideEnteroPositivo() {
        int numero;
        String cadena;
        cadena = teclado.nextLine();
        numero=Integer.parseInt(cadena); // NumberFormatException
        if (numero<0){
            throw new NumeroNegativoException ("Has introducido un numero negativo");
        }
        return numero;
    }

    /**
     * Este método pide un numero con decimales positivo
     * @param mensaje Es el mensaje que se muestra antes de pedir el dato
     * @return Un double leído
     * @throws NumeroNegativoException Si se introduce un número negativo
     * @throws NumberFormatException No se ha introducido un número cuando es esperado.
     */
    public double pideDoublePositivo(String mensaje) {
        System.out.print(mensaje);
        return this.pideDoublePositivo();
    }

    /**
     * Este método pide un numero con decimales positivo
     * @return Un double leído
     * @throws NumeroNegativoException Si se introduce un número negativo
     * @throws NumberFormatException No se ha introducido un número cuando es esperado.
     */
    public double pideDoublePositivo() {
        double numero;
        String cadena;
        cadena = teclado.nextLine();
        numero=Double.parseDouble(cadena);
        if (numero<0){
            throw new NumeroNegativoException ("Has introducido un numero negativo");
        }
        return numero;
    }

    /**
     * Este método verifica que una palabra solo tenga letras y un mínimo de dos caracteres
     * @param palabra Es la palabra que verificará
     * @return Devuelve true si es el patrón es válido, por lo contrario, devuelve false
     */
    public boolean esPalabra(String palabra) {
        String patron = "^[a-zA-Z]{2,}$"; // Expresión regular para asegurar que una palabra solo tenga letras, sin espacios
        // y un mínimo de dos caracteres
        return Pattern.matches(patron, palabra);
    }

    /**
     * Este método valida si una matrícula cumple con los requisitos de una matrícula Española, 4 dígitos y 3 letras
     * donde no serán admitidas vocales ni la Ñ
     * @param matricula Es la matricula a verificar
     * @return Devuelve true si el patrón es correcto, de lo contrario devuelve false
     */
    public boolean esMatricula(String matricula) {
        // Expresión regular que acepta 4 dígitos seguidos de 3 consonantes en mayúsculas
        String patronMatriculaEspana = "^[0-9]{4}[BCDFGHJKLMNPQRSTVWXYZ]{3}$";
        return Pattern.matches(patronMatriculaEspana,matricula);
    }

    /**
     * Este método genera un número aleatorio desde el 0 al número que se le pase por parámetro
     * @param numeroLimite Es el valor que puede tomar como límite máximo
     * @return Devuelve el número generado entre esos dos límites
     */
    public int numeroAleatorioDesdeCero(int numeroLimite){
        int numeroAleatorio = (int) (Math.random() * (numeroLimite+1));
        return numeroAleatorio;
    }

    /**
     * Este método genera un número aleatorio desde el 1 al número que se le pase por parámetro
     * @param numeroLimite Es el valor que puede tomar como límite máximo
     * @return Devuelve el número generado entre esos dos límites
     */
    public int numeroAleatorioDesdeUno(int numeroLimite){
        int numeroAleatorio = (int)(Math.random()*numeroLimite+1);
        return numeroAleatorio;
    }

    /**
     * Este método genera un número aleatorio entre los dos números indicado por parámetro
     * @param limiteInferior Es el límite inferior (desde donde puede empezar)
     * @param limiteSuperior Es el límite superior (hasta donde puede llegar)
     * @return Devuelve el número generado entre esos dos límites
     */
    public int numeroAleatorioEntreDosRangos(int limiteInferior, int limiteSuperior) {
        // Genera un número aleatorio entre limiteInferior (inclusive) y limiteSuperior (inclusive)
        return (int) (Math.random() * (limiteSuperior - limiteInferior + 1) + limiteInferior);
    }

    /**
     * Este método compara dos objetos para ver si son iguales
     * @param object1 Es el primer objeto a comparar
     * @param object2 Es el segundo objeto a comparar
     * @return Devuelve true si son iguales, de lo contrario devuelve false
     */

    public boolean objetosIguales(Object object1, Object object2) {
        if (object1.getClass() == object2.getClass()){
            if(object1.equals(object2)){
                return true;
            }
        } return false;
    }

    /**
     * Este método limpia el buffer, se puede usar cuando gestionamos excepciones por introducir un dato de forma correcta
     * y queremos capturar la excepción y volver a pedir el dato para que no se quede en el buffer el mismo dato incorrecto
     * introducido anteriomente
     */

    public void limpiarBuffer() {
        teclado.nextLine();
    }

    /*
    USAR ESTOS METODOS EN LA CLASE DEL TIPO DE OBJETO QUE VAMOS A COMPARAR
    public boolean equals(Object usr) {
           boolean iguales = false;
           System.out.println("Usa el metodo equals de Usuario");
           Usuario usuario = (Usuario) usr;
           if(usr !=null && usuario.getClass() == usr.getClass()){
                   if (usuario.getDni()==dni && usuario.getApellidos()==apellidos && usuario.getNombre() == nombre){
                           iguales = true;
                   }
           }
           return iguales;
        }
    public int hashCode() {
          System.out.println("Se emplea hashCode del objeto Usuario"); //Este mensaje se elimina tras las pruebas

          PONER TODAS LAS PROPIEDADES QUE TENGA LA CLASE

          return (this.dni+this.nombre+this.apellidos).hashCode();
    }
     */

    /*
    public String toString() {
            PONER TODAS LAS PROPIEDADES QUE TENGA LA CLASE
                return ("Nombre: "+nombre+"\nApellidos: "+apellidos+"\nDNI: "+dni);
        }
     */
}
