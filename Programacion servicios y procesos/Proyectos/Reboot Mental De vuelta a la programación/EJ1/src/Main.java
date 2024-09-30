import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce una hora del dia. Ej: [ Tramos de 6 a 12, de 13 a 20 y de 21 a 5 respectivamente]");
        int hora = sc.nextInt();
        if(hora >= 0 && hora <=23){
            if(hora >= 6 && hora <=12){
                System.out.println("Buenos días");
            }else if(hora >= 13 && hora <= 20){
                System.out.println("Buenas tardes");
            }
            else{
                System.out.println("Buenas noches");
            }
        }else{
            System.out.println("hora incorrecta");
        }

    }
}