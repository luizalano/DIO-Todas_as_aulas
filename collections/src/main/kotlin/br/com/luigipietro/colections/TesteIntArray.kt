package br.com.luigipietro.colections

fun main(){
    val valores = IntArray(5)
    val valores2 = intArrayOf(3,6,9,6,99,0,-2)

    valores[0] = 258
    valores[1] = 987
    valores[2] = 7174
    valores[3] = 87
    valores[4] = 9

    for (valor in valores) println(valor)
    println("------------------------")
    valores.forEach {
        println(it)
    }
    println("------------------------")
    valores.forEach { valor -> println(valor) }

    println("------------------------")
    for (i in valores.indices) {
        println("Item ${i} -> ${valores[i]}.")
    }

    valores.sort()
    println("------------------------")
    valores.forEach { valor -> println(valor) }

    println("------------------------ 2")
    for (i in valores2.indices) {
        println("Item ${i} -> ${valores2[i]}.")
    }

    valores2.sort()
    println("------------------------")
    valores2.forEach { valor -> println(valor) }

}