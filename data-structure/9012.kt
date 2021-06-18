import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val x = nextInt()
    for (i in 1..x) {
        var a = next()
        while (a.isNotEmpty()) {
            if (a.contains("()")) {
                if (a == "()") {
                    println("YES")
                    break
                } else {
                    val b = a.indexOf(")")
                    if (b == 0) {
                        println("NO")
                        break
                    }
                    a = a.removeRange(b - 1..b)

                }
            } else {
                println("NO")
                break
            }
        }

    }
}