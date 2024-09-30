import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int suma = 0 ;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce dos números enteros, rango del 1 al ...");
        System.out.println("Número 1");
        int num1 = sc.nextInt();
        System.out.println("Número 2");
        int num2 = sc.nextInt();

        while(num1 > num2){
            System.out.println("Error, números incorrectos, el prime número debe ser mas pequeño que el segundo");
            System.out.println("Número 1");
            num1 = sc.nextInt();
            System.out.println("Número 2");
            num2 = sc.nextInt();
        }

        for(int i = num1; i <= num2; i++){
            if(i % 3 == 0){
                suma += i;
            }
        }
        System.out.println("La suma de los números divisibles por 3 es: " + suma);
    }
}