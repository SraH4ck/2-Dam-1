fun main(){
    var horas:Int
    var minutos:Int
    var segundos:Int
    println("Introduce la hora")
    var horaTxt = readln()
    var hora = horaTxt.split(":")
    if (hora.size == 3){
        horas = hora[0].toInt()
        minutos = hora[1].toInt()
        segundos = hora[2].toInt()
        if(horas <= 23 && minutos<=59 && segundos <= 59){
            println("¿Cúantos segundos deseas incrementar?")
            var incremento = readln().toInt()
            segundos += incremento

            do{
                if (segundos >= 60){
                    minutos +=1
                    segundos -= 60
                    if (segundos <= 0){

                    }
                    if(minutos > 59){
                        horas +=1
                        minutos = 0
                        if (horas == 24){
                            horas = 0
                        }
                    }
                }
            }while(segundos >= 60)
            println("La hora incrementada es: $horas:$minutos:$segundos ")

        }else{
            print("Hora incorrecta")
        }
    }else{
        print("Hora incorrecta")
    }
}