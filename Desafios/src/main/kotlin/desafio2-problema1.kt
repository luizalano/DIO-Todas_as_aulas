fun main(args: Array<String>) {
    //continue a solução
    fun Float.format(digits: Int) = "%.${digits}f".format(this).replace(',','.')
    println("Quanto cê ganha?")
    val r = readLine()!!.toFloat()
    var ir = 0F
    var prev = 0F

    val limiteIR = listOf<Float> (1903.98F, 2826.65F, 3751.05F, 4664.68F)
    val descIR = listOf<Float> (0F, 142.80F, 354.80F, 636.13F, 869.36F)
    val aliIR = listOf<Float>(0F, 0.075F, 0.15F, 0.225F, 0.275F)

    val limiteP = listOf<Float> (1039.0F, 2098.6F, 3134.4F, 6101.06F)
    val aliP = listOf<Float> (0.075F, 0.09F, 0.12F, 0.14F)

    if (r <= limiteIR[0]  ) {
        ir = 0F
    } else if (r <= limiteIR[1]) {
        ir = r * aliIR[1] - descIR[1]
    } else if (r <= limiteIR[2]  ) {
        ir =  r * aliIR[2] - descIR[2]
    } else if (r <= limiteIR[3]) {
        ir = r * aliIR[3] - descIR[3]
    } else {
        ir = r * aliIR[4] - descIR[4]
    }

    if (r <= limiteP[0]) {
        prev = r * aliP[0]
    } else if (r <= limiteP[1]){
        prev = r * aliP[1]
    } else if (r <= limiteP[2]) {
        prev = r * aliP[2]
    } else if (r <= limiteP[3]) {
        prev = r * aliP[3]
    } else prev = limiteP[3] * aliP[3]


    println("De IR você paga R$ ${ir.format(2)}")
    println("De INSS você paga R$ ${prev.format(2)}")
    println("Você leva pra casa R$ ${(r - ir - prev).format(2)}")

}
