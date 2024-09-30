import java.time.LocalDate;
import java.util.Date;

public class Viaje {
    private LocalDate fechaInicioViaje;
    private int nochesDeEstancia;
    private int costeDesplazamiento;
    private String dni;
    private Hotel hotel;
    private double precioTotal;
    private final int idViaje;

    public Viaje(LocalDate fechaInicioViaje, int nochesDeEstancia, int costeDesplazamiento, String dni, Hotel hotel, int idViaje) {
        this.fechaInicioViaje = fechaInicioViaje;
        this.nochesDeEstancia = nochesDeEstancia;
        this.costeDesplazamiento = costeDesplazamiento;
        this.dni = dni;
        this.hotel = hotel;
        this.idViaje = idViaje;
    }

    public double getPrecioTotal(){
        if (hotel.getNumeroDeEstrellas() == 3 || hotel.getNumeroDeEstrellas() == 2){
            double descuento = 0.10; // descuento del 10%

            if(fechaInicioViaje.getMonth().getValue() == 2){
                precioTotal = costeDesplazamiento + (hotel.getPrecioNoche() * nochesDeEstancia);
                precioTotal = precioTotal - (precioTotal * descuento);
            }
        }else{
            precioTotal = costeDesplazamiento + (hotel.getPrecioNoche() * nochesDeEstancia);
        }
        return precioTotal;
    }


    public LocalDate getFechaInicioViaje() {
        return fechaInicioViaje;
    }

    public int getNochesDeEstancia() {
        return nochesDeEstancia;
    }

    public int getCosteDesplazamiento() {
        return costeDesplazamiento;
    }

    public String getDni() {
        return dni;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public int getIdViaje() {
        return idViaje;
    }
}
