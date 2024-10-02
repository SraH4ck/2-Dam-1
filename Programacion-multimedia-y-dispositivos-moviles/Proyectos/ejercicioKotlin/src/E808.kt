fun main(){
    // Representación en vertical
    
   /* println("Introduce un número para realizar su presentanción en binario")
    var digito = readln().toInt()
    var digitoBinario:Int
    while(digito >= 1){
        digitoBinario = digito % 2
        digito /= 2
        println(digitoBinario)
    }*/

    // Representación en horizontal

    println("Introduce un número para realizar su presentanción en binario")
    var digito = readln().toInt()
    var digitoBinario:Int
    var binarioTxt: ArrayList<String> = arrayListOf()

    while(digito >= 1){
        digitoBinario = digito % 2
        digito /= 2
        binarioTxt.add(digitoBinario.toString())
    }
    for( i in binarioTxt.reversed()){
        print(i)
    }
}