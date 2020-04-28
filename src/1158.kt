import java.util.*

fun main() {
    val x = readLine()
    val stringArray = x!!.split(" ")
    val n = stringArray[0].toInt()
    val k = stringArray[1].toInt()

    val queue = ArrayDeque<Int>()
    for (i in 1..n) {
        queue.add(i)
    }
    print("<")
    while (queue.isNotEmpty()) {
        if (queue.size == 1) {
            print(queue.element())
            queue.remove()
            break
        }
        for (i in 1 until k) {
            var a = queue.first
            queue.addLast(a)
            queue.removeFirst()
        }
       print(queue.first)
        print(", ")
        queue.removeFirst()
    }
    print(">")
}


//        for (i in array) {
//            if (count == k) {
//                //array.remove(i)
//                if (!josephus.containsAll(listOf(i))) {
//                    josephus.add(i)
//                    print(i)
//                    if(josephus.size!=n) print(", ")
//                    count = 1
//                }
//
//                //  array.withIndex()
//            } else {
//                if (!josephus.containsAll(listOf(i))) {
//                   count++
//                }
//            }
//        }

