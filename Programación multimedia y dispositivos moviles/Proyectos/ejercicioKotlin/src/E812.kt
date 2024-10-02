fun main(){
    println("Introduce la altura del triangulo: ")
    var numero = readln().toInt()
    var altura = 1

    while (altura <= numero){
        var j = 1 // reiniciar j para cada nueva fila

        //imprimir los espacios para formar el triangulo
        while(j <= numero - altura){
            print(" ")
            j++
        }
        j = 1 // reiniciar j para escribir los asteriscos

        //imprimir los asteriscos
        while(j <= altura){
            print(" *")
            j++
        }
        println()
        altura++
    }
    //Tenemos que reiniciar las variables ya que no tenemos un for normal y no se realiza dicha inicialización
    // entonces debemos hacerlo manual
}