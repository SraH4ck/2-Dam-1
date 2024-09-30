fun main(){
    println("Introduce una fecha")

    println("Año: ")
    var anio = readln().toInt()
    println("Mes: ")
    var mes = readln().toInt()
    println("Día: ")
    var dia = readln().toInt()

    if(mes <=12 && dia <= 31 && mes != 0 && dia != 0){
        if (mes == 1 || mes == 3 || mes == 5 || mes == 7  || mes == 8 ||mes == 10  || mes == 12){
            dia += 1
            if (dia  > 31){
                mes += 1
                dia = 1
                if (mes > 12){
                    mes = 1
                    anio += 1
                }
            }
        }else if(mes == 2){
            dia += 1
            if (dia > 28){
                mes +=1
                dia = 1
            }
        }else{
            dia += 1
            if (dia >30){
                mes += 1
                dia = 1
            }
        }
        println("La fecha aumentada un dia es: $anio/$mes/$dia")
    }else{
        println("Fecha incorrecta")
    }
}