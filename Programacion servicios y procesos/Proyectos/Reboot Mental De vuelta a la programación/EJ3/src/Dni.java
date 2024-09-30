public class Dni {
    String dni;

    public Dni(String dni) {
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }

    public boolean isDniValido(){
        // Verifica si el DNI tiene 9 caracteres
        if (dni.length() != 9) {
            return false;
        }

        // Extrae los números y la letra del DNI
        String numerosStr = dni.substring(0, 8);
        char letra = dni.toLowerCase().charAt(8);

        // Verifica que los primeros 8 caracteres sean números
        try {
            int numeros = Integer.parseInt(numerosStr);
        } catch (NumberFormatException e) {
            return false;
        }

        // Letras válidas del DNI según el resto
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE".toLowerCase();

        // Calcula la letra correcta
        int indice = Integer.parseInt(numerosStr) % 23;
        char letraCorrecta = letras.toLowerCase().charAt(indice);

        // Compara la letra proporcionada con la calculada
        return letra == letraCorrecta;
    }
}
