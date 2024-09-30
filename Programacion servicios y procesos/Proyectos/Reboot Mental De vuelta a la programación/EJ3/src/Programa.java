import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;


public class Programa {
    private final Scanner sc;
    private DateTimeFormatter formatoFecha;

    public Programa() {
        sc = new Scanner(System.in);
        formatoFecha = DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(java.time.format.ResolverStyle.STRICT);
    }

    public void ejecutar(){
        Viaje viaje;
        boolean confirmarViaje;
        boolean consultarViajes;
        int idViaje = 0;

        boolean respuesta = obtenerRespuesta("Quieres contratar un viaje [si/no]");

        while(respuesta){
            viaje = crearObjetoViaje(idViaje);
            confirmarViaje = obtenerRespuesta("Confirmar el viaje: [si/no]");
            if (confirmarViaje){
                confirmacionViaje(idViaje,viaje);
                idViaje++;
            }
            respuesta = obtenerRespuesta("Quieres contratar un viaje [si/no]");
        }
        consultarViajes = obtenerRespuesta("¿Quieres consultar viajes contratados? [si/no]");
        while (consultarViajes) {
            consultarPrecioTotalViajesContratados();
            System.out.println("Fin de la consulta");
            consultarViajes = obtenerRespuesta("¿Quieres consultar viajes contratados? [si/no]");
        }
        sc.close();
    }

    private boolean obtenerRespuesta(String mensaje) {
        String respuesta;
        // Expresión regular que permite las variaciones de "sí" y "no"
        String patron = "^(si|sí|s|no|n)$";

        do {
            System.out.println(mensaje);
            respuesta = sc.nextLine().trim().toLowerCase();
        } while (!respuesta.matches(patron));

        return respuesta.startsWith("s");
    }


    private void consultarPrecioTotalViajesContratados() {
        String nombreHotel = obtenerNombreHotel("Introduce el nombre del hotel que quieres consultar");
        LocalDate fechaInicio;
        LocalDate fechaFin;

        do {
            fechaInicio = obtenerFecha("Introduce la fecha inicial (dd/MM/yyyy):");
            fechaFin = obtenerFecha("Introduce la fecha final (dd/MM/yyyy):");

            if (fechaFin.isBefore(fechaInicio)) {
                System.out.println("Error: La fecha final no puede ser anterior a la fecha inicial. Inténtalo de nuevo.");
            }
        } while (fechaFin.isBefore(fechaInicio));

        // Una vez validadas las fechas, obtenemos y mostramos el sumatorio total de los viajes
        double sumatorio = Agencia.getSumatorioTotal(fechaInicio, fechaFin, nombreHotel);
        System.out.println("Sumatorio total de precio de los viajes: " + sumatorio + "€");
    }

    private LocalDate obtenerFecha(String mensaje) {
        System.out.println(mensaje);
        boolean fechaValida = false;
        LocalDate fechaInicio = null;
        do {
            try{
                fechaInicio = LocalDate.parse(sc.nextLine(),formatoFecha);
                fechaValida = true;
            }catch (DateTimeParseException e){
                System.out.println("Fecha invalida ejemplo: dd/MM/yyyy");
            }

        }while(!fechaValida);
        return fechaInicio;

    }

    private void confirmacionViaje(int idViaje, Viaje viaje) {
        Agencia.viajesGestionados[idViaje] = viaje;
    }

    private Viaje crearObjetoViaje(int idViaje) {
        Hotel hotel;
        Viaje viaje;
        LocalDate fechaInicio;
        int nocheEstancia;
        String dni;
        String nombreHotel;

        nombreHotel = obtenerNombreHotel("Introduce el nombre del hotel");
        fechaInicio = obtenerFechaInicioAlquiler("Introduce la fecha en la que quieres alojarte");
        nocheEstancia = obtenerNumNochesEstancia("Introduce las noches de estancia");

        dni = obtenerDni("Introduce tu DNI");

        hotel = new Hotel(4,25,nombreHotel);
        viaje = new Viaje(fechaInicio,nocheEstancia,25,dni,hotel,idViaje);
        return viaje;
    }

    private LocalDate obtenerFechaInicioAlquiler(String mensaje) {
        LocalDate fecha = null;
        LocalDate fechaActual = LocalDate.now();
        boolean fechaValida = false;

        do {
            System.out.println(mensaje);
            try {
                fecha = LocalDate.parse(sc.nextLine(), formatoFecha);
                if (fecha.isBefore(fechaActual)) {
                    System.out.println("La fecha debe ser igual o posterior a la fecha actual: " + fechaActual.format(formatoFecha));
                } else {
                    fechaValida = true;
                }
            } catch (DateTimeParseException e) {
                System.out.println("Fecha inválida. Por favor, introduce una fecha válida en formato " + fechaActual.format(formatoFecha));
            }
        } while (!fechaValida);

        return fecha;
    }

    private String obtenerDni(String mensaje) {
        System.out.println(mensaje);
        String dni = sc.nextLine();
        Dni objetoDni = new Dni(dni);
        while(!objetoDni.isDniValido()){
            System.out.println("Dni incorrecto, intentalo de nuevo");
            dni = sc.nextLine();
            objetoDni = new Dni(dni);
        }
        return dni;
    }

    private int obtenerNumNochesEstancia(String mensaje) {
        int noches = 0;
        System.out.println(mensaje);
        do {
            try{
                noches = Integer.parseInt(sc.nextLine());
            }catch (NumberFormatException e){
                System.err.println("Debes elegin mínimo una noche");
            }
        }while(noches<1);
        return noches;
    }

    private String obtenerNombreHotel(String mensaje) {
        String nombre;
        do {
            System.out.println(mensaje);
            nombre = sc.nextLine();
        }while(!isNombreHotel(nombre));
        return nombre;
    }

    private boolean isNombreHotel(String nombre) {
        String expresionRegular = "^[A-Za-z ]{3,}$";
        return nombre.matches(expresionRegular);
    }
}
