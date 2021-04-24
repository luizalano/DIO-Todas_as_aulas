
fun main(args: Array<String>) {
    val nc = readLine()?.toInt()

    for (i in 1..nc!!){
        val v = readLine()!!.split(" ").run{
            val raios:ArrayList<Int> = arrayListOf<Int>()
            raios.add(this[0].toInt())
            raios.add(this[1].toInt())
            raios
        }
        println(v[0]+v[1])
    }
}