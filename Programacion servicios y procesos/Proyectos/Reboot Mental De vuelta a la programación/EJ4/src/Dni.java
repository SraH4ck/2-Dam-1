public class Dni {
String dni;

    public Dni(String dni) {
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }

    public boolean isDniValido(){
        if (dni.length() != 9) {
            return false;
        }

        String numerosStr = dni.substring(0, 8);
        char letra = dni.toLowerCase().charAt(8);

        try {
            int numeros = Integer.parseInt(numerosStr);
        } catch (NumberFormatException e) {
            return false;
        }

        String letras = "TRWAGMYFPDXBNJZSQVHLCKE".toLowerCase();


        int indice = Integer.parseInt(numerosStr) % 23;
        char letraCorrecta = letras.toLowerCase().charAt(indice);

        return letra == letraCorrecta;
    }

}
