fun main(){
    ingresarValores()
}

fun ingresarValores() {
    var multiplosDeDos = 0
    var multiplosDeCinco = 0
    for (i in 1..10) {
        println("Introduce un número")
        var numero = readln().toInt()
        if (numero % 2 == 0){
            multiplosDeDos++
        }
        if(numero % 5 == 0){
            multiplosDeCinco++
        }
    }
    println("Has introducido: \n" +
            "Múltiplos de 5 --> $multiplosDeCinco\n" +
            "Múltiplos de 2 --> $multiplosDeDos")
}
