fun retornarSuperficie1(lado: Int): Int {
    val sup = lado * lado
    return sup
}

fun main() {
    print("Ingrese el valor del lado del cuafrado:")
    val la = readln().toInt()
    val superficie = retornarSuperficie1(la)
    println("La superficie del cuadrado es $superficie")
}