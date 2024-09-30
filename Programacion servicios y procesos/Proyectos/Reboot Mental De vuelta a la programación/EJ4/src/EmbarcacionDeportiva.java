public class EmbarcacionDeportiva extends Barco{

    private int potenciaEnCv;
    public EmbarcacionDeportiva(String matricula, int eslora, int anioFabricacion, int potenciaEnCv) {
        super(matricula, eslora, anioFabricacion);
        this.potenciaEnCv = potenciaEnCv;
    }

    @Override
    public double calcularModulo() {
        return super.calcularModulo() + potenciaEnCv;
    }
}
