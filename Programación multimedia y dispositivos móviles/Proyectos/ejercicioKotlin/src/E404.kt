fun main(){
    println("Introduce una cantidad de segundos")
    
    var segundos = readln().toInt()
    var horas = segundos / 60 / 60
    segundos -= horas * 60 * 60
    var minutos = segundos / 60
    segundos -= minutos * 60

    println("Con los segundos introducidos son: Horas-> $horas Minutos -> $minutos Segundos -> $segundos")
}