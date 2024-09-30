public class Main {
    public static void main(String[] args) {
        try{
            Programa programa = new Programa();
            programa.ejecutar();
        } catch (Exception e) {
            System.out.println("Error no controlado");
        }

    }
}