public class YatesDeLujo extends Barco{
    private int potenciaEnCv;
    private int numCamarotes;

    public YatesDeLujo(String matricula, int eslora, int anioFabricacion, int potenciaEnCv, int numCamarotes) {
        super(matricula, eslora, anioFabricacion);
        this.potenciaEnCv = potenciaEnCv;
        this.numCamarotes = numCamarotes;
    }

    @Override
    public double calcularModulo() {
        return super.calcularModulo() + numCamarotes + potenciaEnCv;
    }
}
