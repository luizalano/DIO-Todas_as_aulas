fun main(args: Array<String>) {

    val N = readLine()!!.toInt()
    for (i in 1..N) {
        val trio:String = readLine()!!.toString()
        val n1 = trio.substring(0,1).toInt()
        val l1 = trio.substring(1,2)
        val n2 = trio.substring(2,3).toInt()

        if (n1 == n2) {
            println(n1 * n2)
        } else{
            if (l1 == l1.toUpperCase()) println(n2-n1)
            else println(n2+n1)
        }
    }
}