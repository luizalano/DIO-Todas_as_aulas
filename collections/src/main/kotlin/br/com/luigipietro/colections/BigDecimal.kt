package br.com.luigipietro.colections

import java.math.BigDecimal
import kotlin.math.pow

fun Array<BigDecimal>.somatoria() = this.reduce {
        acc, valor -> acc + valor
}

fun Array<BigDecimal>.media() =
    if(this.isEmpty()) BigDecimal.ZERO
    else this.somatoria() / this.size.toBigDecimal()

fun Double.raiz(radicando:Int) = this.pow(1.0/radicando.toDouble())

fun main() {
    val salarios = arrayOf(
        "2000".toBigDecimal(),
        "1500".toBigDecimal(),
        "4000".toBigDecimal()
    )
    val valor1:Double = 9.0

    println("----------------------")
    println(salarios.somatoria())

    println("----------------------")
    println(salarios.media())

    println("----------------------")
    println(valor1.raiz(2))
}