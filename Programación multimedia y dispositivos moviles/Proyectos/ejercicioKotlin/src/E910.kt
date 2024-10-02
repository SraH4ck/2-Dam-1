fun main() {
    print("Introduce la cantidad de dias: ")
    var dias = readln().toInt()
    print("Introduce la cantidad de horas: ")
    var horas = readln().toInt()
    print("Introduce la cantidad de minutos: ")
    var minutos = readln().toInt()
    var segundos = calcularSegundos(dias,horas,minutos)
    println("La cantidad de segundos es: $segundos")
}

fun calcularSegundos(dias: Int, horas: Int, minutos: Int):Int {
    val segundosEnDia = 86400
    val segundosEnHora = 3600
    val segundosEnMinuto = 60
    return (dias * segundosEnDia) + (horas * segundosEnHora) + (minutos * segundosEnMinuto)
}
