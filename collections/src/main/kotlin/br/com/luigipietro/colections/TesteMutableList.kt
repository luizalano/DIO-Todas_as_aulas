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

    val funcionarios = mutableListOf(joao, maria)

    funcionarios.add(genesio)
    funcionarios.add(pedro)
    funcionarios.add(carlo)
    funcionarios.add(godofredo)
    funcionarios.add(marta)
    funcionarios.add(anna)
    funcionarios.add(gertrude)

}
