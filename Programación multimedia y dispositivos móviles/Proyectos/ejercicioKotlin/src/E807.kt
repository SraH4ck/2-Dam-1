fun main(){
    println("Introduce 10 números. Veremos cuantos son positivos/negativos, múltiplo de 15 y cuantos pares")
    var positivos = 0
    var negativos = 0
    var multiploDeQuince = 0
    var pares = 0

    var numero:Int
    for(i in 1..10){
        numero = readln().toInt()
        if(numero%2 == 0) pares++
        if (numero < 0) negativos++
        if(numero>0) positivos++
        if(numero%15 == 0) multiploDeQuince++
    }
    println("Pares: $pares\n" +
            "Negativos: $negativos\n" +
            "Positivos: $positivos\n" +
            "Multiplos de quince: $multiploDeQuince")
}