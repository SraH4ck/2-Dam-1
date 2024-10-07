import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        if(args.length == 1){
            String nombreFichero = args[0];
            File file = new File(nombreFichero);

            if (file.exists()) {
                if (file.isFile()) {
                    if (file.canRead()){
                        try(BufferedReader br = new BufferedReader(new FileReader(file))){{
                            while (br.ready()){
                                System.out.println(br.readLine());
                            }
                        }

                        }catch (Exception e){

                        }
                    }
                }
            } else System.err.println("\nEl archivo no existe, compruebe el nombre o la ruta");
        }else System.out.println("Introduce como parámetro un archivo");
    }
}