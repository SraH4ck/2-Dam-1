import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {


       /* try (FileInputStream fis = new FileInputStream("archivo.txt")) {
            int byteRead;
            while ((byteRead = fis.read()) != -1) {
                System.out.print((char) byteRead); // Imprime el contenido del archivo
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        FileReader is = new FileReader("fichero1.txt");
        //BufferedInputStream bis = new BufferedInputStream(is);
        int byteRead;
        while ((byteRead = is.read()) != -1) {
            System.out.print( byteRead);
        }


    }



    }
