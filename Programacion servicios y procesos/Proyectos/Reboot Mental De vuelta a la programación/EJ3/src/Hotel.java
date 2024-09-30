public class Hotel {
    private int numeroDeEstrellas;
    private int precioNoche;
    private String nombre;

    public Hotel(int numeroDeEstrellas, int precioNoche, String nombre) {
        this.numeroDeEstrellas = numeroDeEstrellas;
        this.precioNoche = precioNoche;
        this.nombre = nombre;
    }

    public int getNumeroDeEstrellas() {
        return numeroDeEstrellas;
    }

    public int getPrecioNoche() {
        return precioNoche;
    }

    public String getNombre() {
        return nombre;
    }
}
