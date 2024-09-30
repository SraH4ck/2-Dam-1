import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double bitcoin;
        final double conversionEuros;
        Scanner sc;
        sc = new Scanner(System.in);

        System.out.println("¿Introduce cuantos bitcoin tienes para ver la conversión en euros?");
        bitcoin = sc.nextDouble();
        conversionEuros = 56621.08;
        System.out.println("la conversion es: " + bitcoin * conversionEuros + " euros");
    }
}