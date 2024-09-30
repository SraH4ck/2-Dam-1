import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Alquiler {
    private String nombre;
    private Dni dni;
    private LocalDate fechaInicial;
    private LocalDate fechaFinal;
    private String posicionAmarre;
    private Barco barco;
    private final double TARIFA_FIJA;

    public Alquiler(String nombre, Dni dni, LocalDate fechaInicial, LocalDate fechaFinal, String posicionAmarre, Barco barco) {
        this.nombre = nombre;
        this.dni = dni;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.posicionAmarre = posicionAmarre;
        this.barco = barco;
        this.TARIFA_FIJA = 800;
    }


    public double calcularAlquiler() {
        //Calculamos los dias que hay entre la fecha inicio y la final
        // Sumamos 1 para que incluya el dia de la fecha inicio y la fin ejemplo 1/10/2024 - 5/10/2024 debe de dar 5 días de alquiler
        long diasAlquiler = ChronoUnit.DAYS.between(fechaInicial, fechaFinal) + 1;
        System.out.println("Dias de alquiler:" + diasAlquiler);
        return diasAlquiler * barco.calcularModulo() * TARIFA_FIJA;
    }
}
