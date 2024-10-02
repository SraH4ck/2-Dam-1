fun main() {
    divisoresPrimos()
}

fun divisoresPrimos() {
    println("Introduce un número:")
    val numero = readln().toInt()
    var divisor = 1
    while (divisor <= numero) {

        if (numero % divisor == 0) {
            // Incluimos el 1 como primo como el enunciado del ejercicio E810 (aunque no esta considerado como primo)
            var esPrimo = true // Suponemos que i es primo que equivale al 1
            if (divisor < 1) { // No puede haber numeros primos por debajo de 1
                esPrimo = false
            }else{
                for (j in 2..<divisor) {
                    if (divisor % j == 0) {
                        esPrimo = false // i no es primo si es divisible por j
                    }
                }
            }
            if (esPrimo) {
                println("$divisor Es un número primo")
            }
        }
        divisor++
    }
}
