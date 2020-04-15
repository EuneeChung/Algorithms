import java.util.*
import kotlin.collections.ArrayList

fun main() = with(Scanner(System.`in`)) {
    val x = nextInt()
    var array = ArrayList<Int>()
    for (i in 1..x) {
        when (val a = next()) {
            "push" -> array.add(nextInt())
            "pop" ->
                if (array.isEmpty()) println(-1)
                else {
                    println(array.get(array.lastIndex))
                    array.removeAt(array.lastIndex)
                }
            "empty" -> if (array.isEmpty()) println(1) else println(0)
            "size" -> println(array.count())
            "top" ->
                if (array.isEmpty()) println(-1)
                else {
                    println(array.get(array.lastIndex))

                }

        }
    }

}