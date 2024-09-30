fun main() {
    var cantidad = 0
    print("Cuantos triángulos procesará:")
    val n = readln().toInt()
    for(i in 1..n) {
        print("Ingrese el valor de la base:")
        val base = readln().toInt()
        print("Ingrese el valor de la altura:")
        val altura = readln().toInt()
        val superficie = base * altura / 2
        println("La superficie es de $superficie")
        if (superficie > 12)
            cantidad++
    }
    print("La cantidad de triángulos con superficie superior a 12 son: $cantidad")
}
