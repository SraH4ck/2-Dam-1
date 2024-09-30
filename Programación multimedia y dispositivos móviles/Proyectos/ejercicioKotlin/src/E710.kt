fun main(){
    println("Introduce una fecha: dia/mes/año de forma numerica")

    var dia = readln().toInt()
    var mes = readln().toInt()
    var anio = readln().toInt()

    if (mes <=12 && dia <=31){
        if (mes == 1 || mes == 3 || mes == 5 || mes == 7  || mes == 8 ||mes == 10  || mes == 12 ){
            if (dia > 0){
                println("fecha correcta")
            }else{
                println("fecha incorrecta")
            }
        }else{
            if(dia in 1..30){
                println("fecha correcta")
            }else{
                println("fecha incorrecta")
            }
        }
    }else{
        println("fecha incorrecta")
    }
}