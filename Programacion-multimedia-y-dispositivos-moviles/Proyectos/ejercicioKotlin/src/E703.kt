fun main(){
    println("Introduce 3 notas [1 - 10]")
    print("Nota 1: ")
    var nota1 = readln().toFloat()
    print("Nota 2: ")
    var nota2 = readln().toFloat()
    print("Nota 3: ")
    var nota3 = readln().toFloat()
    var media = (nota1 + nota2 + nota3) / 3

    if(nota1 <=10 && nota2 <= 10 && nota3 <= 10){
        if (media >= 7){
            println("PROMOCIONADO")
        }else{
            println("NO PROMOCIONADO")
        }
    }else{
        println("Notas introducidas incorrectas, deben ser del 1 - 10")
    }



}