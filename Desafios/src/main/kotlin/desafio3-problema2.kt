
fun main(args: Array<String>) {

    var s : String
    var n : Int
    val r = """0x.*""".toRegex()

    while(true) {
        println("Entre com o número")
        s = readLine().toString()
        val h = 0x25a

        if (r.containsMatchIn(s)){
            val strHex = s.removeRange(0, 2)
            val nl = java.lang.Long.parseLong(strHex, 16)

            println(nl)
        } else {
            n = s.toInt()
            if (n < 0) break

            val h = java.lang.Integer.toHexString(n).toUpperCase()
            println("0x$h")
        }
    }
}