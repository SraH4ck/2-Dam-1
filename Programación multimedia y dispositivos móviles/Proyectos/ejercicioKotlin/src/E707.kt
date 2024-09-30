fun main(){
    println("Introduce 3 números para que sean ordenados de mayor a menor")

    var numero1 = readln().toInt()
    var numero2 = readln().toInt()
    var numero3 = readln().toInt()

    if ( (numero1 > numero2 && numero1 > numero3) ){
        if(numero2 >numero3) {
            println("$numero1 - $numero2 - $numero3")
        }else{
            println("$numero1 - $numero3 - $numero2")
        }
    }
    else if(numero2 > numero1 && numero2 > numero3){
        if(numero1 > numero3){
            println("$numero2 - $numero1 - $numero3")
        }else{
            println("$numero2 - $numero3 - $numero1")
        }
    }else if(numero3 > numero1 && numero3 > numero2){
        if(numero1 > numero2){
            println("$numero3 - $numero1 - $numero2")
        }else{
            println("$numero3 - $numero2 - $numero1")
        }
    }
}