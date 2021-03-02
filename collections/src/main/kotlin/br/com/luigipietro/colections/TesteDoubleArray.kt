package br.com.luigipietro.colections

fun main() {
    val valores = DoubleArray(5)

    valores[0] = 121454.65
    valores[1] = 453221.65
    valores[2] = 454867.12
    valores[3] = 1212.32
    valores[4] = 3.74

    valores.forEachIndexed { index, valor -> println("item $index -> $valor") }

    valores.forEachIndexed { index, valor -> valores[index] = valor*2 }
    println("------------")
    valores.forEachIndexed { index, valor -> println("item $index -> $valor") }

    println("------------")
    println("Media do array: ${valores.average()}")

    val soOsGrandao = valores.filter { valor -> valor >= 3000 }
    println("------------")
    soOsGrandao.forEachIndexed { index, valor -> println("item $index -> $valor") }

    println("------------")
    println(valores.count { valor -> valor in  1200.0..450000.0})



}