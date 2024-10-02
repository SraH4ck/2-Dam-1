fun main(args:Array<String>){
    val multiplo:Int = 7
    println("Introduce un número: ")
    val numero: Int = readln().toInt()
    val resto = numero % 7
    println("Para que el numero introducido: $numero sea múltiplo de 7 hay que sumarle: ${multiplo - resto}")
}