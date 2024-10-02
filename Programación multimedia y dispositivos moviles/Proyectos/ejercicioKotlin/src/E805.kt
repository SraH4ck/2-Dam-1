fun main(){
    var triangulosEquilateros = 0
    var triangulosIsoceles = 0
    var trianguloEscaleno = 0

    println("Introduce lado de los tríangulos. (Y/N)")
    var respuesta = readln()

    while (respuesta.lowercase() != "n"){
        print("Lado 1:")
        var lado1 = readln().toInt()
        print("Lado 2:")
        var lado2 = readln().toInt()
        print("Lado 3:")
        var lado3 = readln().toInt()

        if (lado1 == lado2 && lado2 == lado3){
            triangulosEquilateros ++
        }else if(lado1 != lado2 && lado2 != lado3 && lado1 != lado3){
            trianguloEscaleno ++
        }else {
            triangulosIsoceles++
        }
        println("Introduce lado de los tríangulos. (Y/N)")
        respuesta = readln()
    }
    println("Cantidad de equilateros: $triangulosEquilateros\n" +
            "cantidad de isoceles: $triangulosIsoceles\n" +
            "cantidad de escalenos: $trianguloEscaleno")
}