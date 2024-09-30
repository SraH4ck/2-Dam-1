class HoraExacta(hora:Int, minutos:Int, segundos:Int):
    Hora(hora,minutos){
        var segundos = segundos

        fun setSegundo(valor:Int){
            if(valor in 0..59){
                segundos = valor
            }
        }

        override fun inc(){
            segundos++
        }

        override fun toString(): String {
            return("$hora:$minutos:$segundos")
        }
    }

fun main(){
    var horaExacta = HoraExacta(23,45,22)
    println(horaExacta.toString())
    horaExacta.setSegundo(5)
    println(horaExacta.toString())
    horaExacta.inc()
    println(horaExacta.toString())


}