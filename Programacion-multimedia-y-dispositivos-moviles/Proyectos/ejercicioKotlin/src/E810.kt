fun main() {
    println("Introduce un número")
    val numero = readln().toInt()
    var i = 1

    while (i <= numero) {
        var esPrimo = true // Suponemos que i es primo pero en realidad no se considera primo
            for (j in 2..<i) { // usamos ..< para que nunca se llege a ser i igual a j y entonces siempre acabaria entrendo en el if y no funcionaría
                if (i % j == 0) {
                    esPrimo = false // i no es primo si es divisible por j
                }
            }
        if (esPrimo) {
            println("$i --> Es número primo")
        } else {
            println("$i --> No es número primo")
        }
        i++
    }
}
