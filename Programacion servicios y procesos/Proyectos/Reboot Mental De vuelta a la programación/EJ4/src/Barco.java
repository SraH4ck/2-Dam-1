public class Barco {
    String matricula;
    int eslora;
    int anioFabricacion;

    public Barco(String matricula, int eslora, int anioFabricacion) {
        this.matricula = matricula;
        this.eslora = eslora;
        this.anioFabricacion = anioFabricacion;
    }

    public double calcularModulo() {
        return eslora * 10;
    }
}
