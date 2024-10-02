fun tituloSubrayado(titulo: String, caracter: String = "*") {
    println(titulo)
    for(i in 1..titulo.length)
        print(caracter)
    println()
}

fun main() {
    tituloSubrayado("Sistema de Administracion")
    tituloSubrayado("Ventas", "-")
}