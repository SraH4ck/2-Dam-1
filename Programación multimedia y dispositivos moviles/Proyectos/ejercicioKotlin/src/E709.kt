fun main(){
    println("Introduce una nota 0 - 10")

    var nota = readln().toInt()

    when {
        nota <= 4 -> println("insuficiente (de 0 a 4)")
        nota == 5 -> println("suficiente (5)")
        nota == 6 -> println("bien (6)")
        nota == 7 || nota == 8 -> println("notable (7 y 8 )")
        nota == 9 || nota == 10 -> println("sobresaliente (9 y 10)")
        else -> println("Nota invalida")
    }
}