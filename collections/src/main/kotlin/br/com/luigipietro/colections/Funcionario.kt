package br.com.luigipietro.colections
import java.text.DecimalFormat

data class Funcionario(
    val nome: String,
    val salario: Double,
    val regime: String
){
    override fun toString(): String {
        val df = DecimalFormat("###,###,##0.00")
        return "$regime - $nome tá ganhando ${df.format(salario)}!"
    }
//    override fun toString(): String =
//        """
//            Nome:    $nome
//            Salário: $salario
//        """.trimIndent()
}
