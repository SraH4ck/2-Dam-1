fun main(){
    println("Ingrese un número entre 1 - 99")
    var numero = readln()

    if (numero.length == 2){
        print("Tiene dos digitos")
    }else if(numero.length == 1){
        println("Tiene un digito")
    }else{
        println("Número incorrecto")
    }
}