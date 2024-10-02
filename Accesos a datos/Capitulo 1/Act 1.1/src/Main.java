import java.io.File;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            String directorioActual = args[0];
            File directorio = new File(directorioActual);
            if(directorio.exists()){
                File[] files = directorio.listFiles();
                System.out.println("\nArchivos en el directorio: " + directorioActual + "\n");

                if (files == null) {
                    System.out.println("No hay archivos en el directorio");
                }else{
                    mostrarArchivos(files);
                }
            }else System.out.println("El directorio no existe");


        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("\nIntroduce como argumento el nombre del directorio para ver todos sus archivos.\n");
        }

    }

    private static void mostrarArchivos(File[] files) {
        for (File file : files) {
            System.out.println("Archivo --> " + file.getName());
        }
    }
}