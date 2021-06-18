import java.util.*

fun main() {
    val line = readLine()!!.toInt()
    var deque = ArrayDeque<Int>()
    for (i in 1..line) {
        val a = readLine()
        val empty=deque.isEmpty()
        when (a) {
            "pop_front" -> {
                if (empty) println(-1)
                else {
                    println(deque.first)
                    deque.removeFirst()
                }
            }
            "pop_back" -> {
                if (empty) println(-1)
                else {
                    println(deque.last)
                    deque.removeLast()
                }
            }
            "size"-> println(deque.size)
            "empty"->{
                if(empty) println(1)
                else println(0)
            }
            "front"->{
                if(empty)println(-1)
                else println(deque.first)
            }
            "back"->{
                if(empty)println(-1)
                else println(deque.last)
            }
            else->{
                if(a!!.contains("front")){
                    val strArray=a.split(" ")
                    deque.addFirst(strArray[1].toInt())
                }
                else{
                    val strArray=a.split(" ")
                    deque.addLast(strArray[1].toInt())
                }
            }
        }
    }
}