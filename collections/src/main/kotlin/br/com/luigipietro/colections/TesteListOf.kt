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

    funcionarios.forEach{func -> println(func)}
    println(funcionarios.filter {it.nome.contains("dAs", ignoreCase = true)})

    println("-SORT------------------------------------------------")
    funcionarios.sortedBy { it.salario }.forEach { println(it) }

    println("-GROUPBY------------------------------------------------")
    funcionarios.groupBy { it.regime }.forEach { println(it) }

}