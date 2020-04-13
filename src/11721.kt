import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val a = nextLine()
    for(i in a.indices){
        val b=a.substring(i,i+1)
        if(i%10==9) println(b)
        else print(b)
    }
}