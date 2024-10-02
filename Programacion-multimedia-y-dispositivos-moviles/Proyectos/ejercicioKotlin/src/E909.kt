fun main(){
    println("Introduce un número para ver los pares hasta llegar a él")
    var numero = readln().toInt()
    muestraPares(numero)
}

fun muestraPares(n:Int) {
    for (i in 1..n) {
        if(i % 2 == 0){
            println("El número $i es par")
        }
    }
}
