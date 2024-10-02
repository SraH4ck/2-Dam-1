fun main(){
    println("¿Cúantos sueldos deseas introducir?")
    var cantidadDeSueldos = readln().toInt()
    var vector = Array(cantidadDeSueldos) {0f}
    funcionCarga(vector)
    funcionImpresion(vector)
}

fun funcionCarga(vector: Array<Float>) {
    var sueldo:Float
    for (i in 0..(vector.size - 1)) {
        println("Introduce el sueldo")
        sueldo = readln().toFloat()
        vector[i] = sueldo
    }
}

fun funcionImpresion(vector:Array<Float>) {
    for (i in 0..(vector.size - 1)) {
        println("Sueldo: ${vector[i]}€")
    }
}
