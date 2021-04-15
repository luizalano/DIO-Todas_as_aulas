fun main(args: Array<String>) {
    //continue a solução
    println("Quantas vezes?")
    val n = readLine()!!.toInt()
    //x = (1..231).random()
    for (i in 1..n) {
        //println("Qual o $i º número?")
        //val x = readLine()!!.toInt()
        val x = i
        var divisor = 0
        var primo = "Prime"
        for (j in 2..x-1) {
            val resto:Double = x.toDouble() % j.toDouble()
            if (resto == 0.0){
                divisor = j
                primo = "Not Prime"
                break
            }
        }
        println("$x dividido por $divisor - $primo")
    }

}