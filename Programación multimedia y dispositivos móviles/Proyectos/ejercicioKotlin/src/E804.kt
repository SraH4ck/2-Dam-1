fun main(){
    println("Introduce un numero del 1 - 10")
    var numero = readln().toInt()
    if(numero in  1..10){
        for(i in 1..12){
            println("$numero X $i = ${numero * i}")
        }
    }else println("Número introducido no válido")
}