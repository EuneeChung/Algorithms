import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val x = nextInt()
    for (i in 1..x) {
        val a=nextInt()
        val b=nextInt()
        println("Case #${i}: "+(a+b))
    }

}