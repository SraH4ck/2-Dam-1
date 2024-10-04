public class Hotel {
    private int numeroDeEstrellas;
    private double precioNoche;
    private String nombre;

    public Hotel(int numeroDeEstrellas, int precioNoche, String nombre) {
        this.numeroDeEstrellas = numeroDeEstrellas;
        this.precioNoche = precioNoche;
        this.nombre = nombre;
    }

    public int getNumeroDeEstrellas() {
        return numeroDeEstrellas;
    }

    public double getPrecioNoche() {
        return precioNoche;
    }

    public String getNombre() {
        return nombre;
    }
}
