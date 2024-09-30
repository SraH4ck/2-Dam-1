import java.time.LocalDate;

public class Agencia {
     static Viaje[] viajesGestionados = new Viaje[200];

    public Agencia(){
        viajesGestionados = new Viaje[200];
    }

    public static double getSumatorioTotal(LocalDate fechaInicio, LocalDate fechaFin,String nombreHotel) {
        double sumatorio = 0;
        for (Viaje viajesGestionado : viajesGestionados) {
            if (viajesGestionado != null) {
                if (viajesGestionado.getHotel().getNombre().equals(nombreHotel) &&
                        !viajesGestionado.getFechaInicioViaje().isBefore(fechaInicio) &&
                        !viajesGestionado.getFechaInicioViaje().isAfter(fechaFin)) {

                    sumatorio += viajesGestionado.getPrecioTotal();
                }
            }
        }
        if(sumatorio == 0){
            System.out.println("No se han encontrado viajes en la lista con estas condiciones");
        }
        return sumatorio;
    }
}
