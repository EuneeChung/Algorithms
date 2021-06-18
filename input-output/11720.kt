import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val x = nextInt()
    var sum=0
    val a = next()
    for(i in 0 until x){
        val b=a.substring(i,i+1).toInt()
        sum += b
    }

    println(sum)
}