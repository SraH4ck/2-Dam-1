fun main(){
    println("Introduce un número decimal")

    var numero = readln()
    if((numero[0] == '0' || numero[1] == '0') && numero.length >1 ){
        print("Es casi cero")
    }else{
        println("No es casi cero")
    }
}