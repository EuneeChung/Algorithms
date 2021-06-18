import java.io.BufferedReader
import java.util.*

fun main() {
    val string = readLine()
    val a = readLine()?.toInt()?:0
    val stack = Stack<String>() //Left
    val rightStack=Stack<String>()
    for (i in string.toString()) {
        stack.push(i.toString())
    }

    for (i in 1..a) {
        val edit = readLine()

        when (edit) {
            "L" -> if(stack.isNotEmpty()) rightStack.push(stack.pop())
            "D" -> if(rightStack.isNotEmpty()) stack.push(rightStack.pop())
            "B" -> {
                if(stack.isNotEmpty())  stack.pop()
            }
            else->
            {
                stack.push(edit!!.toCharArray()[2].toString())
            }
        }
        if (i == a) {
            if(stack.isNotEmpty()) for (j in 1..stack.count()) print(stack.get(j-1))
            while (rightStack.isNotEmpty()) print(rightStack.pop())
        }
    }
}

