fun retornarSuperficie(lado: Int) = lado * lado

fun main() {
    print("Ingrese el valor del lado del cuadrado: ")  // Corregido "cuafrado" a "cuadrado"
    val la = readln().toInt()
    println("La superficie del cuadrado es ${retornarSuperficie(la)}")
}
