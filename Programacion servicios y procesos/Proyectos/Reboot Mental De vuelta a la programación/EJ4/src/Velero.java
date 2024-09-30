public class Velero extends Barco{

    int numMastiles;
    public Velero(String matricula, int eslora, int anioFabricacion, int numMastiles) {
        super(matricula, eslora, anioFabricacion);
        this.numMastiles = numMastiles;
    }

    @Override
    public double calcularModulo() {
        return super.calcularModulo() + numMastiles;
    }
}
