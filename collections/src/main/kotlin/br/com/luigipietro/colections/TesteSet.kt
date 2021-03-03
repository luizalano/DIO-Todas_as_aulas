package br.com.luigipietro.colections

fun main() {
    val joao = Funcionario("João das Couve", 4000.0, "CLT")
    val maria = Funcionario("Maria das Abobrinha", -5000.0, "PJ")
    val genesio = Funcionario("Genésio Borboun", 55000.0, "CLT")
    val pedro = Funcionario("Pedro Malasarte", 2000.0, "CLT")
    val carlo = Funcionario("Carlo Marassi", 1000.0, "PJ")
    val godofredo = Funcionario("Godofredo da Alma Penada", 4500.0, "CLT")
    val marta = Funcionario("Marta da Morte", 8000.0, "CLT")
    val anna = Funcionario("Anna Manhano", 12000.0, "PJ")
    val gertrude = Funcionario("Gertrude da Silva", 800.7808, "CLT")

    val funcionarios = listOf(joao, maria, genesio, pedro, carlo, godofredo, marta, anna, gertrude)

    //val funcionariosCLT = setOf(funcionarios.filter { it.regime == "CLT" })
    //val funcionariosPJ = setOf(funcionarios.filter { it.regime == "PJ" })

    val funcionariosCLT = setOf(joao, genesio, pedro, godofredo, marta, gertrude)
    val funcionariosPJ = setOf(maria, carlo, anna)

    val set1 = setOf(joao, genesio, pedro, godofredo, marta, gertrude)
    val set2 = setOf(pedro, marta, maria, carlo, anna)

    funcionariosCLT.forEach { func -> println(func) }
    println("-------------------------------------------------")
    funcionariosPJ.forEach { func -> println(func) }

    println("-union------------------------------------------------")
    val todos = funcionariosCLT.union(funcionariosPJ)
    todos.forEach { func -> println(func) }

    println("-subtract------------------------------------------------")
    var todos2 = todos.subtract(funcionariosPJ)
    todos2.forEach { func -> println(func) }

    println("-minus------------------------------------------------")
    var todos3 = todos.minus(pedro)
    todos3.forEach { func -> println(func) }

    println("-INTERSEC------------------------------------------------")
    val todos4 = set1.intersect(set2)
    todos4.forEach { func -> println(func) }
}