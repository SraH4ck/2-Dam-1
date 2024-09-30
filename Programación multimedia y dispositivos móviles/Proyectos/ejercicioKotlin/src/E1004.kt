open class Hora(hora: Int, minutos:Int){
    var hora = hora
    var minutos = minutos

   open fun inc(){
        minutos++
    }
    fun setMinutos(valor:Int): Boolean{
        if(valor in 0..59){
            minutos = valor
            return true
        }
        return false
    }

    fun setHora(valor:Int): Boolean{
        if (valor in 0..23){
            hora = valor
            return true
        }
        return false
    }

    override fun toString(): String {
        return("$hora:$minutos")
    }
}

fun main(){
    var  hora = Hora(5,14)
    println(hora.setHora(22))
    println(hora.setMinutos(30))
    println(hora.toString())
    hora.inc()
    println(hora.toString())

}