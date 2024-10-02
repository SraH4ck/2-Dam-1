fun main(){
    var cuadrante1 = 0
    var cuadrante2 = 0
    var cuadrante3 = 0
    var cuadrante4 = 0

    println("Cuantas coordenadas se quieren procesar:")
    var cantidadCoordenadas = readln().toInt()

    for (i in 1..cantidadCoordenadas){
        print("Valor X: ")
        var x = readln().toInt()
        print("Valor Y: ")
        var y = readln().toInt()

        if(x > 0 && y > 0) cuadrante1 ++
        else if(x > 0 && y < 0) cuadrante4 ++
        else if (x < 0 && y > 0) cuadrante2 ++
        else if (x < 0 && y < 0) cuadrante3++
    }
    println("Cantidad en el cuadrante 1: $cuadrante1\n" +
            "Cantidad en el cuadrante 2: $cuadrante2\n" +
            "Cantidad en el cuadrante 3: $cuadrante3\n" +
            "Cantidad en el cuadrante 4: $cuadrante4")
}