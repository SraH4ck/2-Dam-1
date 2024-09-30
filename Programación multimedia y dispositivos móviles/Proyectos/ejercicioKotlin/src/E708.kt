fun main(){
    println("Introduce un numero entre 0 - 99999")
    var numero:String = readln()
    var longitud:Int = numero.length

    when (longitud){
        1 -> println("Tiene un dígito")
        2 -> println("Tiene dos dígitos")
        3 -> println("Tiene tres dígitos")
        4 -> println("Tiene cuatro dígitos")
        5 -> println("Tiene cinco digítos")
        else -> println("Número incorrecto")
    }
}