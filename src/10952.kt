import java.util.*

fun main() =with(Scanner(System.`in`)){

    while(hasNextInt()) {
        val a=nextInt()
        val b=nextInt()
        if(a==0&&b==0){
            break
        }
        println(a+b)
    }

}