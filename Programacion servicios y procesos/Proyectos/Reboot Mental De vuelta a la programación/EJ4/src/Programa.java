import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Scanner;

public class Programa {
    private final Scanner sc;
    private final DateTimeFormatter formatoFecha;
    private final String[] barcosDisponibles;

    public Programa() {
        sc = new Scanner(System.in);
        formatoFecha = DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT);
        barcosDisponibles = new String[]{"Barco", "Velero", "Embarcación deportiva", "Yate de lujo"};

    }

    public void ejecutar(){
        mostrarBienvenida();

        String nombre = obtenerNombre("Introduce tu nombre");
        String dni = obtenerDni("Introduce tu DNI");
        
        LocalDate fechaInicio =  obtenerFechaInicio("Introduce la fecha inicio de alquiler [dia/mes/año]");
        LocalDate fechaFin = obtenerFechaFin("Introduce la fecha fin de alquiler [dia/mes/año]",fechaInicio);

        String amarre = obtenerAmarre("Introduce la posición del amarre");
        String tipoBarco = obtenerBarco("Tipo  de barco [Barco - Velero - Yate de lujo - Embarcación deportiva]");

        Barco barco = eleccionTipoBarco(tipoBarco); // puede lanzar una NullPointerException
        Dni dni1 = new Dni(dni);

        Alquiler alquiler = new Alquiler(nombre,dni1, fechaInicio, fechaFin, amarre, barco);

        mostrarCostoAlquiler(alquiler);

        sc.close();
    }

    private String obtenerAmarre(String mensaje) {
        String posicionAmarre = "";
        System.out.println(mensaje);
        String expresionRegular = "^[a-zA-Z][0-9]$";
        boolean amarreValido = false;
        do {
            try{
                posicionAmarre = sc.nextLine();
                if (posicionAmarre.matches(expresionRegular)) {
                    amarreValido = true;
                } else {
                    System.out.println("Introduce una localización válida [letra-numero]");
                }
            }catch (Exception e) {
                System.out.println("Error. Inténtelo de nuevo.");
            }
        } while (!amarreValido);
        return posicionAmarre;
    }

    private String obtenerBarco(String mensaje) throws NullPointerException{
        String tipoBarco;
        do {
            System.out.println(mensaje);
            tipoBarco = sc.nextLine();
        }while(!isTipoBarco(tipoBarco));
        return tipoBarco.toLowerCase();
    }

    private Barco eleccionTipoBarco(String tipoBarco) {
            String matricula = obtenerMatricula("Introduce la matrícula (3 letras y 4 números, por ejemplo ABC1234):");
            int eslora = obtenerEntero("Introduce los metros de eslora"); // posible excepcion si mete algo q no es un número
            int anio = obtenerAnioFabricacion("Introduce el año de fabricación"); // posible excepcion si mete algo q no es un número

        while (!isTipoBarco(tipoBarco)) {
            System.out.println("Tipo de barco incorrecto. Inténtalo de nuevo.");
            tipoBarco = obtenerBarco("Tipo de barco [Barco - Velero - Yate de lujo - Embarcación deportiva]");
        }
            switch(tipoBarco){
                case "barco": // debe de estar en minúsculas para evitar una NullPointerException
                    return new Barco(matricula, eslora, anio);

                case "velero": // debe de estar en minúsculas para evitar una NullPointerException
                    int mastil = obtenerEntero("Introduce cantidad de mastiles del velero");
                    return new Velero(matricula,eslora,anio,mastil);

                case "embarcacion deportiva": // debe de estar en minúsculas para evitar una NullPointerException
                    int potencia = obtenerEntero("Cúanta potencia tiene tu embarcación deportiva");
                    return  new EmbarcacionDeportiva(matricula,eslora,anio,potencia);

                case "yate de lujo": // debe de estar en minúsculas para evitar una NullPointerException
                    int potenciaCv = obtenerEntero("¿Cúanta potencia tiene tu yate?");
                    int camarote = obtenerEntero("Número de camarotes");
                    return new YatesDeLujo(matricula,eslora,anio,potenciaCv,camarote);
            }
        System.out.println("Tipo de barco incorrecto");
        return null; //controlar una posible excepción
    }

    private String obtenerDni(String mensaje){
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

    private String obtenerNombre(String mensaje){
        String nombre;
        do {
            System.out.println(mensaje);
            nombre = sc.nextLine();
        }while(!isNombre(nombre));
        return nombre;
    }

    private void mostrarCostoAlquiler(Alquiler alquiler) {
        System.out.println("Precio del alquiler: " + alquiler.calcularAlquiler() + "€");
    }

    private LocalDate obtenerFechaInicio(String mensaje) {
        LocalDate fecha = null;
        LocalDate fechaActual = LocalDate.now();
        boolean fechaValida = false;

        do {
            System.out.println(mensaje);
            try {
                fecha = LocalDate.parse(sc.nextLine(), formatoFecha); // Intentamos parsear la fecha
                if (fecha.isBefore(fechaActual)) {
                    System.out.println("La fecha debe ser igual o posterior a la fecha actual: " + fechaActual.format(formatoFecha));
                } else {
                    fechaValida = true;
                }
            } catch (DateTimeParseException e) {
                System.out.println("Fecha inválida. Por favor, introduce una fecha válida en formato día/mes/año.");
            }
        } while (!fechaValida);

        return fecha;
    }


    private LocalDate obtenerFechaFin(String mensaje, LocalDate fechaInicio) {
        LocalDate fechaFin = null;
        boolean fechaValida = false;

        do {
            System.out.println(mensaje);
            try {
                fechaFin = LocalDate.parse(sc.nextLine(), formatoFecha);
                if (fechaFin.isBefore(fechaInicio)) {
                    System.out.println("La fecha de fin debe ser igual o posterior a la fecha de inicio: " + fechaInicio.format(formatoFecha));
                } else {
                    fechaValida = true; // La fecha es válida y no es anterior a la fecha de inicio
                }
            } catch (DateTimeParseException e) {
                System.out.println("Fecha inválida. Por favor, introduce una fecha válida en formato día/mes/año.");
            }
        } while (!fechaValida); // Repetir mientras la fecha no sea válida

        return fechaFin;
    }


    private boolean isNombre(String nombre) {
        String expresionRegular = "^[A-Za-zÁÉÍÓÚáéíóúñÑ]{3,}(\\s[A-Za-zÁÉÍÓÚáéíóúñÑ]{3,})*$";
        return nombre.matches(expresionRegular);
    }

    private String obtenerInput(String mensaje) {
        System.out.println(mensaje);
        return sc.nextLine();
    }

    private void mostrarBienvenida() {
        System.out.println("Bienvenido a tu portal de alquiler amarres");
    }

    private String obtenerMatricula(String mensaje) {
        String matricula;
        do {
            System.out.println(mensaje);
            matricula = sc.nextLine();
            if (!isMatricula(matricula)) {
                System.out.println("Matrícula inválida. Inténtalo de nuevo.");
            }
        } while (!isMatricula(matricula));

        return matricula;
    }

    private boolean isMatricula(String matricula) {
        // Definimos un patrón de expresión regular para matrículas de barco
        String regex = "^[A-Z]{3}\\d{4}$"; // Tres letras mayúsculas seguidas de cuatro dígitos
        return matricula.matches(regex);
    }

    private  boolean isTipoBarco(String tipoBarco) {
        for (String barco:barcosDisponibles){
            if (barco.equalsIgnoreCase(tipoBarco)){
                return true;
            }
        }
        return false;
    }
    private int obtenerAnioFabricacion(String mensaje){
        boolean fechaValida = false;
        int antiguedadMaxima = 1950;
        LocalDate fechaActual = LocalDate.now();
        int anioActual = fechaActual.getYear();
        int anioIntroducido = 0;
        while(!fechaValida){
            try{
                System.out.println(mensaje);
                anioIntroducido = Integer.parseInt(sc.nextLine()); // Utilizo nextLine para evitar problemas con sc.nextInt() ya que no toma el caracter de retorno de linea
                // y podría hacer saltarme información
                if (anioIntroducido <= anioActual && anioIntroducido >= antiguedadMaxima){
                    fechaValida = true;
                }else System.out.println("Rango de año de fabricación permitido entre [ " + anioActual + " - " + antiguedadMaxima + " ]");
            }catch (NumberFormatException e){
                System.out.println("Error, solo se admiten números");
            }
        }
        return anioIntroducido;
    }

    private int obtenerEntero(String mensaje) {
        int numero = 0;
        boolean valido = false;
        while (!valido) {
            try {
                System.out.println(mensaje);
                numero = Integer.parseInt(sc.nextLine()); // Utilizo nextLine para evitar problemas con sc.nextInt() ya que no toma el caracter de retorno de linea
                // y podría hacer saltarme información
                if (numero > 0){
                    valido = true;
                }

            } catch (NumberFormatException e) {
                System.out.println("Por favor, introduce un número válido.");
            }
        }
        return numero;
    }
}
