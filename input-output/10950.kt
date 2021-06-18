import java.util.*

fun main() {
    val scan = Scanner(System.`in`)

    val x: Int=scan.nextInt()
    var a: Int
    var b: Int
    println("\n")
    for(i in 1..x){
        a=scan.nextInt()
        b=scan.nextInt()
        println(a+b)
    }

}