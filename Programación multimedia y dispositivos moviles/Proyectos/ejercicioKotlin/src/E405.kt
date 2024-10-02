fun main(){
    println("Introduce 3 distancias:")
    println("Primero en milímetros:")
    var milimetros = readln().toFloat()
    println("Segundo en centímetros: ")
    var centimetros = readln().toFloat()
    println("Tercero en metros: ")
    var metros = readln().toFloat()

    var sumaLongitudes = (milimetros / 10) + centimetros + (metros * 100)

    print("La suma de todo es: $sumaLongitudes centimetros")
}