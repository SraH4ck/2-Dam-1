fun main(){
    println("¿Cuanto cuesta el producto? ")
    val precio: Float = readln().toFloat()
    println("¿Cuantas unidades llevas? ")
    val cantidad: Int = readln().toInt()
    println("El precio a pagar es: ${precio*cantidad}€")
}