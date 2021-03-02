package br.com.luigipietro.colections

fun main() {
    val stringas = Array<String>(5) {""}
    val stringas2 = arrayOf("Jão", "Maria", "Predo", "Zé")

    stringas[0] = "Luiz Alberto Alano"
    stringas[1] = "Paula de Macedo Alano"
    stringas[2] = "Daniel de Macedo Alano"
    stringas[3] = "João das Couves"
    stringas[4] = "Doutor Abobrinha"

    var i:Int = 0
    stringas.forEach {
        println("Item $i -> ${it}!")
        i++
    }
}