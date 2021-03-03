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

    val rep = Repositorio<Funcionario>()

    rep.create("joao", joao)
    rep.create("maria", maria)
    rep.create(genesio.nome, genesio)
    rep.create(pedro.nome, pedro)
    rep.create(carlo.nome, carlo)
    rep.create(godofredo.nome, godofredo)
    rep.create(marta.nome, marta)
    rep.create(maria.nome, maria)
    rep.create(anna.nome, anna)
    rep.create(gertrude.nome, gertrude)

    println(rep.findById(joao.nome))

    println("-------------------------------------------------")
    rep.findAll().forEach{(k, v) -> println("$k -> $v")}
}