import java.io.EOFException
import java.lang.NumberFormatException

fun main(args: Array<String>) {

    while (true) {

        try {

            val l = readLine()!!.toInt()
            val v = readLine()!!.split(" ").run{
                val numbers:ArrayList<Int> = arrayListOf<Int>()
                for( i in this) {
                    numbers.add(i.toInt())
                }
                numbers
            }
            v.sort()
            when (v.last().toInt()) {
                in (0..9) -> println("1")
                in (10..19) -> println("2")
                else -> println("3")
            }

        } catch (f : NumberFormatException) {
            break
        } catch (n : NegativeArraySizeException) {
            break
        } catch (e :NullPointerException) {
            break
        }
    }
}