[[Manejo de ficheros]]

----

### 1. Gestión de Recursos

- **Try-with-resources**: A partir de Java 7, se puede utilizar este bloque para asegurar que los recursos se cierren automáticamente. Por ejemplo:

```java
try (FileReader fic = new FileReader("ruta/del/fichero.txt")) {
    // Leer y procesar el fichero
} catch (IOException e) {
    e.printStackTrace();
}
```

### 2. Lectura y Escritura Eficiente

- **BufferedReader y BufferedWriter**: Usar estas clases mejora la eficiencia al leer/escribir grandes cantidades de datos.

```java
try (BufferedReader br = new BufferedReader(new FileReader("ruta/del/fichero.txt"))) {
    String linea;
    while ((linea = br.readLine()) != null) {
        System.out.println(linea);
    }
}
```

### 3. Escritura de Ficheros

- Al escribir en un fichero, si el fichero ya existe, `FileWriter` lo sobrescribirá. Para añadir contenido sin sobrescribir, se puede utilizar el constructor que acepta un segundo parámetro `true`:
  
```java
FileWriter fw = new FileWriter("ruta/del/fichero.txt", true);
```

### 4. Codificación de Caracteres

- Es importante manejar la codificación correctamente. Para ficheros de texto, considera usar `InputStreamReader` y `OutputStreamWriter` para especificar la codificación (ej. UTF-8):

```java
try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("ruta/del/fichero.txt"), StandardCharsets.UTF_8))) {
    // Leer el fichero
}
```

### 5. Manejo de Errores

- Siempre es bueno loguear los errores en un fichero o consola, para tener un seguimiento en caso de problemas.

### 6. Ejemplos de Ficheros Binarios

- Si en algún momento decides trabajar con ficheros binarios, puedes usar `FileInputStream` y `FileOutputStream` para leer y escribir bytes.