fun main(){
    println("Introduce La hora")
    print("Hora: ")
    var hora = readln().toInt()
    print("Minutos: ")
    var minutos = readln().toInt()
    print("Segundos: ")
    var segundos = readln().toInt()
    if(hora < 24 && minutos < 60 && segundos < 60 ){
        segundos += 1

        if(segundos == 60){
            minutos += 1
            segundos = 0

            if(minutos == 60){
                hora += 1
                minutos = 0

                if (hora == 24){
                    hora = 0
                }
            }
        }
    }
    print("La hora introducida se le suma un segundo y el resultado es: $hora:$minutos:$segundos")
}