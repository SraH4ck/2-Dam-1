import java.math.BigInteger

fun main(){
    println("Introduce un número")
    var numero = readln().toInt()
    var i = 0
    var j:Int
    fun factorial(n:Int):BigInteger{
        var factorial = BigInteger.ONE //Asigna el valor uno
        for (i in 1..n){
            factorial = factorial.multiply(BigInteger.valueOf(i.toLong()))
            //BigInteger.valueOf(i.toLong() --> Convierte el valor de la variable i en un valor tipo BigInteger
            // Y asi poder usar multiply que es un metodo de la clase BigInteger, por eso convertimos i en un tipo BigInteger
        }
        return factorial
    }

    while (i < numero){
        j = 0
        while(j <= i ){
            print(" ${factorial(i).divide(factorial(j).multiply(factorial(i-j)))}")
            j++
        }
        println()
        i++
    }
}